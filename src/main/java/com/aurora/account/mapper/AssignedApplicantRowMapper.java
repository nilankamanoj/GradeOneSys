package com.aurora.account.mapper;

import com.aurora.account.model.AssignedApplicant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignedApplicantRowMapper implements RowMapper{


    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        AssignedApplicant assignedApplicant = new AssignedApplicant();

        assignedApplicant.setApplication_id(rs.getString("application_id"));

        return assignedApplicant;
    }
}
