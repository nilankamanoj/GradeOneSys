/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aurora.account.repository;
import com.aurora.account.mapper.SchoolRowMapper;
import com.aurora.account.model.School;

import java.util.List;

/**
 *
 * @author Dilshan Navodya
 */
public class SchoolRepository extends Repository {

    @Override
    public void saveObj(Object object) {
        School school = (School) object;
        String dataField=school.toString();
        super.stmt.update("insert into school values"+dataField);
    }

    @Override
    public Object getOne(String id) {
        String sql="select * from school where id=?";
        try{
        School school = (School)super.stmt.queryForObject(
			sql, new Object[] { id }, new SchoolRowMapper());
        
        return school;
        }
        catch(org.springframework.dao.EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public boolean checkAvailability(String id) {
        return (getOne(id)==null);
    }
}
