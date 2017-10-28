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
        
        if(applicant.getId().length()!=8 || !applicant.getId().chars().allMatch( Character::isDigit )){
            errors.rejectValue("Id", "Invalid.applicationForm.applicationId");
        }
        else if(applicantService.findOne(applicant.getId())!=null){
            errors.rejectValue("Id", "Duplicate.applicationForm.applicationId");
        }
        
        
        

    }
}
