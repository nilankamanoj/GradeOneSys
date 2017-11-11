
package com.aurora.account.service;
import com.aurora.account.model.Applicant;
import com.aurora.account.repository.ApplicantRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ApplicantService {
    
    private final ApplicantRepository appRepo = new ApplicantRepository();
    
    public void saveApp(Applicant applicant){
        appRepo.saveObj(applicant);
    }
    public Applicant getOne(String id){
        return(Applicant) appRepo.getOne(id);
    }
    public List getIds(){return appRepo.fetchIds();}
    public String getJavaScriptIds(){return appRepo.getJavaScriptIdList();}
    
}
