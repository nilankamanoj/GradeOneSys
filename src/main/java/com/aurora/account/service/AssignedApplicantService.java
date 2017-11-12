package com.aurora.account.service;

import com.aurora.account.model.AssignedApplicant;
import com.aurora.account.repository.AssignedApplicantRepository;
import org.springframework.stereotype.Service;

@Service
public class AssignedApplicantService {
    private final AssignedApplicantRepository assignApplicantRepository= new AssignedApplicantRepository();

    public void saveAssign(AssignedApplicant assignedApplicant){assignApplicantRepository.saveObj(assignedApplicant);}
    public AssignedApplicant getOne(String id){return (AssignedApplicant) assignApplicantRepository.getOne(id);}
    public boolean checkAvailability(String id){return assignApplicantRepository.checkAvailability(id);}
    public boolean availableCombSchApp(String sch_id,String app_id){return  assignApplicantRepository.availbleCombSchApp(sch_id, app_id);}

}
