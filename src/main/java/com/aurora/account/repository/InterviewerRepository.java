package com.aurora.account.repository;

import com.aurora.account.mapper.InterviewerRowMapper;
import com.aurora.account.model.Interviewer;

public class InterviewerRepository extends Repository{
    @Override
    public void saveObj(Object object) {
        Interviewer interviewer =(Interviewer)object;
        super.stmt.update("INSERT INTO interviewer (uid,sch) VALUES (?,?)",interviewer.getUid(),interviewer.getSch());
    }

    @Override
    public Object getOne(String id) {
        String sql = "select * from interviewer where uid = ?";

        try {
            Interviewer interviewer =(Interviewer) super.stmt.queryForObject(
                    sql,new Object[] {id},new InterviewerRowMapper()
            );

            return interviewer;
        }
        catch(org.springframework.dao.EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public boolean checkAvailability(String id) {
        return false;
    }
}
