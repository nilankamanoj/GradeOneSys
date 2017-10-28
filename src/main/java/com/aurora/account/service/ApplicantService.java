package com.aurora.account.service;

import com.aurora.account.model.Applicant;
import com.aurora.account.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ApplicantService{
    @Autowired
    private ApplicantRepository applicantRepository;

    public void save(Applicant applicant) {
        applicantRepository.save(applicant);
    }

}
