package com.aurora.account.service;

import com.aurora.account.model.PastPupil;
import com.aurora.account.repository.PastPupilRepository;
import org.springframework.stereotype.Service;

@Service
public class PastPupilService {
    private final PastPupilRepository pastRepo = new PastPupilRepository();
    
    public void savePastPupil(PastPupil pastPupil){
        pastRepo.saveObj(pastPupil);
    }
    
    public PastPupil getOne(String id){
        return (PastPupil) pastRepo.getOne(id);
    }
    
}
