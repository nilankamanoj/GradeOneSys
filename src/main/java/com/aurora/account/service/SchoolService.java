/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aurora.account.service;
import com.aurora.account.model.School;
import com.aurora.account.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Dilshan Navodya
 */
@Service
public class SchoolService {
    private final SchoolRepository appRepo = new SchoolRepository();
    
    public void saveApp(School school){
        appRepo.saveObj(school);
    }
    public School getOne(String id){
        return(School) appRepo.getOne(id);
    }
    public List getIds(){return appRepo.fetchIds();}
    public String getJavaScriptIds(){return appRepo.getJavaScriptIdList();}
}
