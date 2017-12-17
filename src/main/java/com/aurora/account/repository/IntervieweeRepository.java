package com.aurora.account.repository;

import com.aurora.account.mapper.IntervieweeRowMapper;
import com.aurora.account.model.Interviewee;
import org.springframework.dao.EmptyResultDataAccessException;

public class IntervieweeRepository extends Repository{
    @Override
    public void saveObj(Object object) {
        Interviewee interviewee = (Interviewee) object;
        String data = interviewee.toString();
        super.stmt.update("insert into selected_applicant(application_id, selected_sch_id, result_interview, interviewer) values " +data);
    }

    @Override
    public Object getOne(String id) {
        String query = "select * from selected_applicant where application_id= ? and selected_sch_id= ?";
        String[] pID = id.split(" ");
        String app_id= pID[0]; 
        String sch_id= pID[1];
        try {
            Interviewee Interviewee=(Interviewee) super.stmt.queryForObject(query , 
                    new Object[] {app_id, sch_id}, new IntervieweeRowMapper());
            return Interviewee;            
        }catch(EmptyResultDataAccessException ex) {
            return null;            
        }
    }

    @Override
    public boolean checkAvailability(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
