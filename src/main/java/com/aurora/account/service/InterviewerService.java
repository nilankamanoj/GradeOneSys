package com.aurora.account.service;

import com.aurora.account.model.Interviewer;
import com.aurora.account.repository.InterviewerRepository;
import org.springframework.stereotype.Service;

@Service
public class InterviewerService {

    private final InterviewerRepository interviewerRepository= new InterviewerRepository();

    public void saveInterviwer(Interviewer interviewer){interviewerRepository.saveObj(interviewer);}
    public Interviewer getOne(String uid){return (Interviewer) interviewerRepository.getOne(uid);}


}
