package com.aurora.account.service;

import com.aurora.account.model.PastPupil;
import com.aurora.account.repository.PastPupilRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PastPupilService {
    private final PastPupilRepository pastRepo = new PastPupilRepository();
    
    public void savePastPupil(PastPupil pastPupil){
        pastRepo.saveObj(pastPupil);
    }
    
    public PastPupil getOne(String id){
        return (PastPupil) pastRepo.getOne(id);
    }
    public boolean checkAvailability(String id){return pastRepo.checkAvailability(id);}
    public boolean availbleCombSchStu(String schId,String stuId){return pastRepo.availbleCombSchStu(schId,stuId);}
    public boolean availbleCombSchMem(String schId,String memId){return pastRepo.availbleCombSchMem(schId,memId);}
}
