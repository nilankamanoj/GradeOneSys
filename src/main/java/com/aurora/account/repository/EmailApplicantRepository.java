package com.aurora.account.repository;

import com.aurora.account.model.*;

import java.util.ArrayList;
import java.util.List;

public class EmailApplicantRepository extends Repository{

    private final ApplicantRepository applicantRepository=new ApplicantRepository();
    private final SchoolRepository schoolRepository = new SchoolRepository();
    private final ParentRepository parentRepository =new ParentRepository();
    private final AssignedApplicantRepository assignedApplicantRepository = new AssignedApplicantRepository();


    @Override
    public void saveObj(Object object) {
        //NotSupport
    }

    @Override
    public Object getOne(String id) {
        EmailApplicant emailApplicant = new EmailApplicant();
        AssignedApplicant assignedApplicant=(AssignedApplicant)assignedApplicantRepository.getOne(id) ;

        emailApplicant.setApplicant((Applicant) applicantRepository.getOne(id));
        emailApplicant.setParent((Parent) parentRepository.getOne(assignedApplicant.getNic()));
        emailApplicant.setAssignedApplicant(assignedApplicant);
        emailApplicant.setSchools((ArrayList<School>) getSchools(id));

        return emailApplicant;

    }

    @Override
    public boolean checkAvailability(String id) {
        return false;
    }

    public List<School> getSchools(String id){

        ArrayList<School> schools = new ArrayList<>();


        String query="SELECT DISTINCT sch_id from assigned_applicant where application_id ="+id;
         ArrayList<String> schStrings= (ArrayList<String>) super.stmt.queryForList(query, String.class);

         for(String schString : schStrings){
                schools.add((School) schoolRepository.getOne(schString));
        }

        return schools;
    }

    public List<String> getIdList() {
        String query = "SELECT application_id FROM applicant_parent ";
        return (List<String>) super.stmt.queryForList(query, String.class);
    }
}
