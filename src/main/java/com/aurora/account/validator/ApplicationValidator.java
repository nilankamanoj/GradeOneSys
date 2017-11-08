package com.aurora.account.validator;

import com.aurora.account.model.Applicant;
import com.aurora.account.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ApplicationValidator implements Validator {
   
    @Autowired
    private ApplicantService applicantService;
    
    @Override
    public boolean supports(Class<?> aClass) {
        return Applicant.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Applicant applicant = (Applicant) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Id", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "first_name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "second_name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "initials", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "div_grama", "NotEmpty");
        
        if(applicant.getId().length()!=8 || !applicant.getId().chars().allMatch( Character::isDigit )){
            errors.rejectValue("Id", "Invalid.applicationForm.applicationId");
        }
        if(applicantService.getOne(applicant.getId())!=null){
           errors.rejectValue("Id", "Duplicate.applicationForm.applicationId"); 
        }
        
        String[] partsInitial= applicant.getInitials().split("\\.");
        for(String part : partsInitial){
            if(part.length()!=1){
                errors.rejectValue("initials", "Invalid.applicationForm.initials");
                break;
            }
            else if(!Character.isLetter(part.charAt(0))){
                errors.rejectValue("initials", "Invalid.applicationForm.initials");
                break;
            }
        }
        if(!applicant.getDob().isEmpty()){
        String[] partsDob= applicant.getDob().split("-");
        if(partsDob.length!=3){
            errors.rejectValue("dob", "Invalid.applicationForm.dob");
            
        }
        else if(partsDob[0].length()!=4 || partsDob[1].length()!=2 || partsDob[2].length()!=2){
            errors.rejectValue("dob", "Invalid.applicationForm.dob");
            
        }
        else if(!partsDob[0].chars().allMatch( Character::isDigit )||!partsDob[1].chars().allMatch( Character::isDigit )||!partsDob[2].chars().allMatch( Character::isDigit )){
            errors.rejectValue("dob", "Invalid.applicationForm.dob");
            
        }
        else{
            applicant.setAge(String.valueOf(2017-Integer.parseInt(partsDob[0])));
        }
        }
        
        if(applicant.getGender().trim().equals("NO")){
            errors.rejectValue("gender", "Invalid.applicationForm.gender");
        }
        if(applicant.getReligion().trim().equals("NO")){
            errors.rejectValue("religion", "Invalid.applicationForm.religion");
        }
        if(applicant.getDistrict().trim().equals("empty")){
            errors.rejectValue("district", "Invalid.applicationForm.district");
        }
        if(applicant.getDiv_sec().trim().equals("0")){
            errors.rejectValue("div_sec", "Invalid.applicationForm.div_sec");
        }

        

    }
}
