
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
            applicant.setFirst_name(rs.getString("first_name"));
            applicant.setSecond_name(rs.getString("second_name"));
            applicant.setInitials(rs.getString("initials"));
            applicant.setDob(rs.getString("date_of_birth"));
            applicant.setAge(rs.getString("age"));
            applicant.setGender(rs.getString("gender"));
            applicant.setReligion(rs.getString("religion"));
            applicant.setDistrict(rs.getString("district"));
            applicant.setDiv_sec(rs.getString("div_secretary"));
            applicant.setDiv_grama(rs.getString("div_grama"));
            applicant.setAppResult(Integer.parseInt(rs.getString("result_application")));

        return applicant;

    
}
}
