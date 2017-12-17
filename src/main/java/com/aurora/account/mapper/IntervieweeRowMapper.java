package com.aurora.account.mapper;

import com.aurora.account.model.Interviewee;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class IntervieweeRowMapper implements RowMapper{
    
    @Override
    public Object mapRow(ResultSet rs, int row) throws SQLException {
        Interviewee interviewee = new Interviewee();
        interviewee.setApplication_id(rs.getString("application_id"));
        interviewee.setSelected_sch_id(rs.getString("selected_sch_id"));
        return interviewee;
    }
        
}
