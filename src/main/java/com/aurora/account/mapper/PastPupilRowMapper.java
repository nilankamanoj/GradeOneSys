package com.aurora.account.mapper;

import com.aurora.account.model.PastPupil;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PastPupilRowMapper implements RowMapper{
    
    @Override
    public Object mapRow(ResultSet rs, int row) throws SQLException {
        PastPupil pastPupil = new PastPupil();
        pastPupil.setId(rs.getString("id"));
        return pastPupil;
    }
}
