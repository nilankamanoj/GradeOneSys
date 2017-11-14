package com.aurora.account.mapper;

import com.aurora.account.model.Activity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Activity activity = new Activity();

        activity.setId(rs.getInt("id"));
        activity.setUser_id(rs.getLong("user_id"));
        activity.setActivity(rs.getString("activity"));
        activity.setTime(rs.getString("time"));

        return activity;
    }
}
