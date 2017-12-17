package com.aurora.account.repository;

import com.aurora.account.model.Interviewee;
import org.springframework.dao.EmptyResultDataAccessException;
import com.aurora.account.mapper.PastPupilRowMapper;

public class IntervieweeRepository extends Repository{
    @Override
    public void saveObj(Object object) {
        Interviewee interviewee = (Interviewee) object;
        String data = interviewee.toString();
        super.stmt.update("insert into selected_applicant(application_id, selected_sch_id, result_interview, interviewer) values " +data);
    }

    @Override
    public Object getOne(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkAvailability(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
