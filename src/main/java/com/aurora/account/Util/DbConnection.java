/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aurora.account.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 *
 * @author nilanka
 */
public class DbConnection {
   // @Autowired
   // private DataSource dataSourceTemplate;
    public JdbcTemplate getConnection(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/GradeOneSchema");
        dataSource.setUsername("finley");
        dataSource.setPassword("password");

        //ApplicationContext context = new ClassPathXmlApplicationContext("appconfig-data.xml");
        // get bean declared with name "dataSource" in the configuration file
      //  DriverManagerDataSource dataSource = (DriverManagerDataSource) context.getBean("dataSource");
       JdbcTemplate stmt=new JdbcTemplate(dataSource);
        return stmt;
    }
    
}