package com.aurora.account.Util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbConnection {

    public JdbcTemplate getConnection(){

        Properties props = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("application.properties");
        try {
            props.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(props.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(props.getProperty("jdbc.url"));
        dataSource.setUsername(props.getProperty("jdbc.username"));
        dataSource.setPassword(props.getProperty("jdbc.password"));

       JdbcTemplate stmt=new JdbcTemplate(dataSource);
        return stmt;
    }
    
}