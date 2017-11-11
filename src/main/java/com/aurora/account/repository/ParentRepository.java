/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aurora.account.repository;

import com.aurora.account.mapper.ParentRowMapper;
import com.aurora.account.model.Parent;

import java.util.List;

/**
 *
 * @author Sithara wanigasooriy
 */
public class ParentRepository extends Repository{
    @Override
    public List fetchIds() {
        return null;
    }

    @Override
    public String getJavaScriptIdList() {
        return null;
    }

    @Override
    public void saveObj(Object object) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Parent parent = (Parent) object;
        String dataField=parent.toString();
        super.stmt.update("insert into parent values"+dataField);
    }

    @Override
    public Object getOne(String NIC) throws org.springframework.dao.EmptyResultDataAccessException{
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql="select * from parent where id=?";
        try{
        Parent parent = (Parent)super.stmt.queryForObject(
			sql, new Object[] { NIC }, new ParentRowMapper());
        
        return parent;
        }
        catch(org.springframework.dao.EmptyResultDataAccessException ex){
            return null;
        }
    }
    
}

