package com.hlf.custemprpt

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class VideoLinkSecAppInsert (
        private val caJdbcTemplate: NamedParameterJdbcTemplate
) {

    companion object VideoLinkSecAppInsert {
        class TABLES {

        }

    }

    fun createTrilGid(tableName: String): String? {
        val query = """select generatetril(
                         (select object_type from scc_type_to_table_map where table_name = :tableName),
                          tril_seq_internal.nextval) from dual"""

        val params = mapOf<String, String>("tableName" to tableName)
        return caJdbcTemplate.queryForObject(query, params, String::class.java)
    }


    @ShellMethod("createProgramGid")
    fun createProgramGid() {
        System.out.println(createTrilGid("OCTProgram"))

    }

    @ShellMethod("videos")
    fun video(): String {
        System.out.println("video insert")
        return "video"
    }

}




