/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aurora.account.mapper;

import com.aurora.account.model.Parent;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sithara wanigasooriy
 */
public class ParentRowMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Parent parent = new Parent();
        parent.setNIC(rs.getString("id"));
        parent.setFirst_name(rs.getString("first_name"));
        parent.setSecond_name(rs.getString("second_name"));
        parent.setInitials(rs.getString("initials"));
        parent.setOccupation(rs.getString("occupation"));
        parent.setGender(rs.getString("gender"));
        parent.setTelephone_no(rs.getString("telephone_no"));
        parent.setEmail(rs.getString("email"));

        return parent;
    }
    
}

