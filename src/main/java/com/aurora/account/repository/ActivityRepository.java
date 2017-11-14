package com.aurora.account.repository;

import com.aurora.account.model.Activity;

import java.util.List;

public class ActivityRepository extends Repository{
    @Override
    public void saveObj(Object object) {
        Activity activity = (Activity)object;
        String datafield = activity.toString();
        super.stmt.update("INSERT INTO activity VALUES"+datafield);


    }

    @Override
    public Object getOne(String id) {
        return null;
    }

    @Override
    public boolean checkAvailability(String id) {
        String query = "SELECT id FROM activity WHERE user_id ='"+id+"'";
        return ((List<String>) super.stmt.queryForList(query, String.class)).size()!=0;
    }
}
