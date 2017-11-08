/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aurora.account.validator;

import com.aurora.account.model.School;
import com.aurora.account.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Dilshan Navodya
 */
@Component
public class SchoolValidator implements Validator{

    @Autowired
    private SchoolService schoolService;
    
    @Override
    public boolean supports(Class<?> aClass) {
        return School.class.equals(aClass);    }

    @Override
    public void validate(Object o, Errors errors) {
        School school = (School) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sch_id", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "province", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "district", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "division", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eligible_count", "NotEmpty");
         
       if(school.getSch_id().length()!=8 || !school.getSch_id().chars().allMatch( Character::isDigit )){
            errors.rejectValue("sch_id", "Invalid.schoolForm.schoolId");
        }
        if(schoolService.getOne(school.getSch_id())!=null){
           errors.rejectValue("sch_id", "Duplicate.schoolForm.schoolId"); 
        }
         if(school.getProvince().trim().equals("empty")){
            errors.rejectValue("province", "Invalid.schoolForm.province");
        }
        if(school.getDivision().trim().equals("0")){
            errors.rejectValue("division", "Invalid.schoolForm.division");
        } 
        try {
            Integer.parseInt(school.getEligible_count().trim());
        } catch (NumberFormatException e) {
            errors.rejectValue("eligible_count", "Invalid.schoolForm.eligible_count");
        }
    }
}
