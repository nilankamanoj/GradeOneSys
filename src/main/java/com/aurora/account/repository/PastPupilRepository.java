
package com.aurora.account.repository;
import com.aurora.account.model.PastPupil;
import org.springframework.dao.EmptyResultDataAccessException;
import com.aurora.account.mapper.PastPupilRowMapper;

import java.util.List;

public class PastPupilRepository extends Repository{

    @Override
    public void saveObj(Object object) {
        PastPupil pastPupil = (PastPupil) object;
        String data = pastPupil.toString();
        super.stmt.update("insert into past_pupil values " +data);
    }

    @Override
    public Object getOne(String id) throws EmptyResultDataAccessException{
        String query = "select * from past_pupil where id= ?";
        try {
            PastPupil pastPupil=(PastPupil) super.stmt.queryForObject(query , 
                    new Object[] {id}, new PastPupilRowMapper());
            return pastPupil;            
        }catch(EmptyResultDataAccessException ex) {
            return null;            
        }
        
    }

    @Override
    public List fetchIds() {
        String query="SELECT DISTINCT id from past_pupil";
        return (List<String>) super.stmt.queryForList(query, String.class);
    }

    @Override
    public String getJavaScriptIdList() {
        return super.toJavascriptArray(this.fetchIds());
    }

    public boolean availbleCombSchStu(String schId,String stuId){
        String query ="SELECT DISTINCT id FROM past_pupil WHERE student_id='"+stuId+"' AND school_id='"+schId+"'";
        return ((List<String>) super.stmt.queryForList(query, String.class)).size()==0;
    }

    public boolean availbleCombSchMem(String schId,String memId){
        String query ="SELECT DISTINCT id FROM past_pupil WHERE past_pupil_member_id='"+memId+"' AND school_id='"+schId+"'";
        return ((List<String>) super.stmt.queryForList(query, String.class)).size()==0 || memId.length()==0 || memId==null;
    }


}
