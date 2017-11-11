/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aurora.account.service;

import com.aurora.account.model.Parent;
import com.aurora.account.repository.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Sithara wanigasooriy
 */
@Service
public class ParentService {
    private final ParentRepository parentRepo = new ParentRepository();
    public void saveApp(Parent parent){
        parentRepo.saveObj(parent);
    }
    public Parent getOne(String NIC){
        return(Parent) parentRepo.getOne(NIC);
    }
    public boolean checkAvailability(String id){return parentRepo.checkAvailability(id);}
}
