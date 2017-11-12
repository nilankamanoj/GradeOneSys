
package com.aurora.account.mapper;

import org.springframework.jdbc.core.RowMapper;
import com.aurora.account.model.Applicant;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ApplicantRowMapper implements RowMapper{

        @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Applicant applicant = new Applicant();

            applicant.setApplication_id(rs.getString("application_id"));

        return applicant;

    
}
}
