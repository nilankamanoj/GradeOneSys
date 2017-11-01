/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aurora.account.Util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author nilanka
 */
public class DbConnection {
    public JdbcTemplate getConnection(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/GradeOneSchema");
        dataSource.setUsername("finley");
        dataSource.setPassword("password");
        JdbcTemplate stmt=new JdbcTemplate(dataSource);
        return stmt;
    }
    
}
