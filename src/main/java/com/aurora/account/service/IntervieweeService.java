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
    
}
