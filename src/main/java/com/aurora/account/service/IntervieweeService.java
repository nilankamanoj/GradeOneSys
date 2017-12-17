package com.aurora.account.service;

import com.aurora.account.model.Interviewee;
import com.aurora.account.repository.IntervieweeRepository;
import org.springframework.stereotype.Service;

@Service
public class IntervieweeService {
    private final IntervieweeRepository interviewRepo = new IntervieweeRepository();
    
    public void saveInterviewee(Interviewee interviewee){
        interviewRepo.saveObj(interviewee);
    }
    
    public Interviewee getInterviewee(String app_id, String sch_id){
        String id = app_id + " " + sch_id;
        return (Interviewee) interviewRepo.getOne(id);
    }
    
}
