package com.aurora.account.repository;

import com.aurora.account.model.Activity;

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
        return false;
    }
}
