package com.aurora.account.repository;
import com.aurora.account.mapper.ApplicantRowMapper;
import com.aurora.account.model.Applicant;

public class ApplicantRepository extends Repository{

    @Override
    public void saveObj(Object object) {
        Applicant applicant = (Applicant) object;
        String dataField=applicant.toString();
        super.stmt.update("insert into applicant values"+dataField);
        
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



  
}
