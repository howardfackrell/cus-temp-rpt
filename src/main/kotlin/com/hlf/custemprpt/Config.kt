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
        dataSource.url = "CHANGE_ME"
        dataSource.username = "CHANGE_ME"
        dataSource.password = "CHANGE_ME"

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
        config.jdbcUrl = "CHANGE_ME"
        config.username = "CHANGE_ME"
        config.password = "CHANGE_ME"
        config.maximumPoolSize = 10
        config.minimumIdle = 1

        return NamedParameterJdbcTemplate(HikariDataSource(config));
    }

}