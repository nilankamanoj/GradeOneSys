package com.aurora.account.service;

import com.aurora.account.model.EmailApplicant;
import com.aurora.account.repository.EmailApplicantRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailApplicantService {
    private final EmailApplicantRepository emailApplicantRepository =new EmailApplicantRepository();

    public EmailApplicant getOne(String id){return (EmailApplicant)emailApplicantRepository.getOne(id);}

}
