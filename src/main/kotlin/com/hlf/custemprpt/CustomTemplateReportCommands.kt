package com.hlf.custemprpt

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import java.io.File
import java.sql.ResultSet


@ShellComponent
class CustomTemplateReportCommands(
        private val caJdbcTemplate: NamedParameterJdbcTemplate,
        private val dctmJdbcTemplate: NamedParameterJdbcTemplate
) {

    @ShellMethod("Say hello")
    fun hello(): String {
        return "Hello world"
    }

    @ShellMethod("test the db connection")
    fun test(): Int? {
        val params: HashMap<String, Any> = HashMap();
        val count = dctmJdbcTemplate.queryForObject("select count(*) from printbrochure_template", params, Int::class.java);

        return count
    }

    fun countCustomTemplates(): Map<String, Int> {
        val params: HashMap<String, Any> = HashMap()
        val sql =
                "select c.CLIENT_NUMBER_STP, count(t.A_WEBC_URL) as count\n" +
                        "from PRINTBROCHURE_TEMPLATE t\n" +
                        "       join PRINTBROCHURE_TEMPLATE_CLIENT c on t.A_WEBC_URL = c.A_WEBC_URL\n" +
                        "where t.PRINT_TEMPLATE_TYPE = 'Block'\n" +
                        "  and  t.COMMUNICATION_TYPE = 'PrintBrochure'\n" +
                        "  and t.PAGE_SIZE = '7x7'\n" +
                        "group by c.CLIENT_NUMBER_STP\n" +
                        "order by c.CLIENT_NUMBER_STP"


        val pairs: List<Pair<String, Int>> = dctmJdbcTemplate.query(sql, { rs: ResultSet, rowNum: Int ->
            Pair<String, Int>(rs.getString("CLIENT_NUMBER_STP"), rs.getInt("COUNT"))
        });

        val customTemplateCount: Map<String, Int> = pairs.foldRight(HashMap<String, Int>(), { pair, acc ->
            acc.put(pair.first, pair.second)
            acc
        })

        return customTemplateCount
    }


    fun allActiveStps(): List<String> {
        val params: HashMap<String, Any> = HashMap();
        val sql = "select distinct(c.soldtopartynumber)\n" +
                "  from octcustomer c\n" +
                "join sc_organization o on c.tril_gid = o.octcustomer\n" +
                "join octprogram p on o.tril_gid = p.customer and p.status in (30, 40)\n" +
                "join octbrochuretemplates bt on p.brochuretemplate = bt.tril_gid and bt.templatefamily = 'Block'\n" +
                "order by c.soldtopartynumber";
        val stps: List<String> = caJdbcTemplate.queryForList(sql, params, String::class.java)
        return stps;
    }

    class Customer(
            val stp: String,
            val name: String,
            val standardPrograms: Int,
            val customPrograms: Int,
            var customTemplates: Int) {

        fun csv(): String {
            return "$stp,\"$name\",$standardPrograms,$customPrograms,$customTemplates"
        }

        companion object {
            fun header(): String {
                return "Sold To,Name,Standard Programs,Custom Programs,Custom Templates"
            }
        }
    }


    fun allActiveCustomers(): Map<String, Customer> {
        val params: HashMap<String, Any> = HashMap();
        val sql = "select distinct(c.soldtopartynumber), c.name,\n" +
                "                count(distinct(case when r.brochurefamily = 'BS' then p.tril_gid else null end)) as standard,\n" +
                "               count(distinct(case when r.brochurefamily = 'BC' then p.tril_gid else null end)) as custom\n" +
                "                 from octcustomer c\n" +
                "               join sc_organization o on c.tril_gid = o.octcustomer\n" +
                "               join octprogram p on o.tril_gid = p.customer and p.status in (30, 40)\n" +
                "               join octbrochuretemplates bt on p.brochuretemplate = bt.tril_gid and bt.templatefamily = 'Block'\n" +
                "join octbrochurerule r on bt.octbrochurerule = r.tril_gid\n" +
                "group by c.soldtopartynumber, c.name\n" +
                "       order by c.soldtopartynumber, c.name";

        val customers = caJdbcTemplate.query(sql, params, { rs: ResultSet, i: Int ->
            Customer(stp = rs.getString("SOLDTOPARTYNUMBER"),
                    name = rs.getString("NAME"),
                    standardPrograms = rs.getInt("STANDARD"),
                    customPrograms = rs.getInt("CUSTOM"),
                    customTemplates = 0)
        })

        val customersMap = customers.foldRight(HashMap<String, Customer>(), { cust, acc ->
            acc.put(cust.stp, cust)
            acc
        })
        return customersMap
    }


    @ShellMethod("lists all active STP's, with the number of custom templates for each")
    fun reportStp(): String {

        val customerMap = allActiveCustomers()
        val customTemplates = countCustomTemplates()

        customerMap.values.forEach { customer ->
            customer.customTemplates = customTemplates.getOrDefault(customer.stp, 0)
        }

        val activeClientsWithCustomTemplate = customerMap.filter({ entry -> entry.value.customTemplates > 0 }).size
        val activeClientsWithStandardTemplates = customerMap.size - activeClientsWithCustomTemplate

        val rpt = customerMap.map({ entry ->
            entry.value.csv()
        }).sorted()

        File("report.csv").writeText(Customer.header() + "\n" + rpt.joinToString("\n"))

        return "There are $activeClientsWithCustomTemplate custom clients, $activeClientsWithStandardTemplates standard clients. ${customerMap.size} total"

    }

}