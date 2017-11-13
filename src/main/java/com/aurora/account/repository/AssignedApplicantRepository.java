package com.aurora.account.repository;
import com.aurora.account.mapper.AssignedApplicantRowMapper;
import com.aurora.account.model.AssignedApplicant;

import java.util.List;

public class AssignedApplicantRepository extends Repository {
    @Override
    public void saveObj(Object object) {
    AssignedApplicant asapp=(AssignedApplicant) object;

    String parentData = asapp.toStringForApplicantParent();
    super.stmt.update("insert into applicant_parent values"+parentData);

        if(asapp.getSch_id1().length()==8){
            super.stmt.update("insert into assigned_applicant values"+asapp.toStringForAssignedApplicant1());
        }
        if(asapp.getSch_id2().length()==8){
            super.stmt.update("insert into assigned_applicant values"+asapp.toStringForAssignedApplicant2());
        }
        if(asapp.getSch_id3().length()==8){
            super.stmt.update("insert into assigned_applicant values"+asapp.toStringForAssignedApplicant3());
        }
        if(asapp.getSch_id4().length()==8){
            super.stmt.update("insert into assigned_applicant values"+asapp.toStringForAssignedApplicant4());
        }
        if(asapp.getSch_id5().length()==8){
            super.stmt.update("insert into assigned_applicant values"+asapp.toStringForAssignedApplicant5());
        }


    }

    @Override
    public Object getOne(String id) {
        String sql="select * from applicant_parent where application_id=?";
        try{
            AssignedApplicant assignedApplicant = (AssignedApplicant) super.stmt.queryForObject(
                    sql, new Object[] { id }, new AssignedApplicantRowMapper());

            return assignedApplicant;
        }
        catch(org.springframework.dao.EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public boolean checkAvailability(String id) {
        return (getOne(id)==null);
    }

    public boolean availbleCombSchApp(String schId,String appId){
        String query ="SELECT DISTINCT application_id FROM assigned_applicant WHERE application_id='"+appId+"' AND sch_id='"+schId+"'";
        return ((List<String>) super.stmt.queryForList(query, String.class)).size()==0;
    }
}
