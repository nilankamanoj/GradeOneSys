package com.aurora.account.repository;
import com.aurora.account.mapper.ApplicantRowMapper;
import com.aurora.account.model.Applicant;

import java.util.List;

public class ApplicantRepository extends Repository{

    @Override
    public void saveObj(Object object) {
        Applicant applicant = (Applicant) object;
        String dataField=applicant.toString();
        super.stmt.update("insert into applicant values(?,?,?,?,?,?,?,?,?,?,?,?)",
                applicant.getId(),applicant.getFirst_name(),applicant.getSecond_name(),applicant.getInitials(),applicant.getDob(),
                applicant.getGender(),applicant.getReligion(),applicant.getAge(),applicant.getDistrict(),applicant.getDiv_sec(),
                applicant.getDiv_grama(),applicant.getAppResult());
        
    }

    @Override
    public Object getOne(String id) throws org.springframework.dao.EmptyResultDataAccessException {
        String sql="select * from applicant where application_id=?";
        try{
        Applicant applicant = (Applicant)super.stmt.queryForObject(
			sql, new Object[] { id }, new ApplicantRowMapper());
        
        return applicant;
        }
        catch(org.springframework.dao.EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public boolean checkAvailability(String id) {
        return (getOne(id)==null);
    }


}
