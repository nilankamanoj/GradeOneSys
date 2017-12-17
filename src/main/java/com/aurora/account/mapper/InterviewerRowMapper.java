package com.aurora.account.mapper;

import com.aurora.account.model.Interviewer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InterviewerRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Interviewer interviewer=new Interviewer();
        interviewer.setUid(resultSet.getString("uid"));
        interviewer.setSch(resultSet.getString("sch"));
        return interviewer;
    }
}
