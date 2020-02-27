package com.hlf.custemprpt

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource


@Configuration
class Config {

    @Bean
    fun caDataSource(): DataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver")
        dataSource.url = "jdbc:oracle:thin:@tlit.octanner.com:1521:tlit"
        dataSource.username = "sc_read"
        dataSource.password = "sc_read"

        return dataSource
    }

    @Bean
    fun caJdbcTemplate(): NamedParameterJdbcTemplate {

        val config = HikariConfig()
        config.dataSource = caDataSource()
        config.maximumPoolSize = 10
        config.minimumIdle = 1

        return NamedParameterJdbcTemplate(HikariDataSource(config));
    }

    @Bean
    fun dctmJdbcTemplate(): NamedParameterJdbcTemplate {

        val config = HikariConfig()
        config.jdbcUrl = "jdbc:oracle:thin:@docqa1.octanner.com:1521/docqa12c"
        config.username = "oct_qa_scs"
        config.password = "oct_qa_scs"
        config.maximumPoolSize = 10
        config.minimumIdle = 1

        return NamedParameterJdbcTemplate(HikariDataSource(config));
    }

}
