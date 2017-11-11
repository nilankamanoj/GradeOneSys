/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aurora.account.validator;

import com.aurora.account.model.Parent;
import com.aurora.account.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
/**
 *
 * @author Sithara wanigasooriy
 */
@Component
public class ParentValidator implements Validator{
    @Autowired
    private ParentService parentService;

    @Override
    public boolean supports(Class<?> aClass) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return Parent.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Parent parent = (Parent) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "NIC", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "first_name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "second_name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "initials", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "occupation", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");

        parent.setNIC(parent.getNIC().toLowerCase());
        
        if(parent.getNIC().length()!=10){
            errors.rejectValue("NIC", "Invalid.parentForm.NIC");
        }
        if(parentService.getOne(parent.getNIC())!=null){
           errors.rejectValue("NIC", "Duplicate.parentForm.NIC"); 
        }
        
        String[] partsInitial= parent.getInitials().split("\\.");
        for(String part : partsInitial){
            if(part.length()!=1){
                errors.rejectValue("initials", "Invalid.parentForm.initials");
                break;
            }
            else if(!Character.isLetter(part.charAt(0))){
                errors.rejectValue("initials", "Invalid.parentForm.initials");
                break;
            }
        }
        if(parent.getOccupation().chars().anyMatch(Character::isDigit)){
            errors.rejectValue("occupation", "Invalid.parentForm.occupation");
            
        }
        
        
        if(parent.getGender().trim().equals("NO")){
            errors.rejectValue("gender", "Invalid.parentForm.gender");
        }
        if (parent.getTelephone_no().length()==10){
            try {
               Integer.parseInt(parent.getTelephone_no().trim());
           } catch (NumberFormatException e) {
               errors.rejectValue("telephone_no", "Invalid.parentForm.telephone_no");
           }
        }else{
            errors.rejectValue("telephone_no", "Invalid.parentForm.telephone_no");
        }
        
    }
    
}

