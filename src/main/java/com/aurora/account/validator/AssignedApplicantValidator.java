package com.aurora.account.validator;

import com.aurora.account.model.AssignedApplicant;
import com.aurora.account.service.ApplicantService;
import com.aurora.account.service.AssignedApplicantService;
import com.aurora.account.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



@Component
public class AssignedApplicantValidator implements Validator{
    private AssignedApplicant assignedApplicant;
    private Errors errors;
    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private AssignedApplicantService assignedApplicantService;

    @Autowired
    private SchoolService schoolService;

    @Override
    public boolean supports(Class<?> aClass) {
        return AssignedApplicant.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        this.assignedApplicant = (AssignedApplicant) o;
        this.errors=errors;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "application_id", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nic", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sch_id1", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "distance1", "NotEmpty");

        if(assignedApplicant.getApplication_id().length()!=8 || !assignedApplicant.getApplication_id().chars().allMatch( Character::isDigit )){
            errors.rejectValue("application_id","Invalid.assignForm.appId");
        }
        else if(applicantService.getOne(assignedApplicant.getApplication_id())==null){
            errors.rejectValue("application_id","NotListed.assignForm.appId");
        }
        else if(assignedApplicantService.getOne(assignedApplicant.getApplication_id())!=null){
            errors.rejectValue("application_id","Duplicate.assignForm.appId");
        }

        if(validateSchId(assignedApplicant.getSch_id1(),"sch_id1")&&validDistance(assignedApplicant.getDistance1(),"distance1")){
            assignedApplicant.setApplication_result1(calculateMark(assignedApplicant.getDistance1()));
        }

        if(assignedApplicant.getSch_id2().length()==8){
            if(validateSchId(assignedApplicant.getSch_id2(),"sch_id2")&&
            validDistance(assignedApplicant.getDistance2(),"distance2")){
                assignedApplicant.setApplication_result2(calculateMark(assignedApplicant.getDistance2()));
            }
        }
        if(assignedApplicant.getSch_id3().length()==8){
            if(validateSchId(assignedApplicant.getSch_id3(),"sch_id3")&&
            validDistance(assignedApplicant.getDistance3(),"distance3")){
                assignedApplicant.setApplication_result3(calculateMark(assignedApplicant.getDistance3()));
            }
        }
        if(assignedApplicant.getSch_id4().length()==8){
            if(validateSchId(assignedApplicant.getSch_id4(),"sch_id4")&&
            validDistance(assignedApplicant.getDistance4(),"distance4")){
                assignedApplicant.setApplication_result4(calculateMark(assignedApplicant.getDistance4()));
            }
        }
        if(assignedApplicant.getSch_id5().length()==8){
            if(validateSchId(assignedApplicant.getSch_id5(),"sch_id5")&&
            validDistance(assignedApplicant.getDistance5(),"distance5")){
                assignedApplicant.setApplication_result5(calculateMark(assignedApplicant.getDistance5()));
            }
        }








    }

    private boolean validateSchId(String sch_id,String name){
        if(sch_id.length()!=8 || !sch_id.chars().allMatch( Character::isDigit )){
            errors.rejectValue(name,"Invalid.assignForm.schId");
            return false;
        }
        else if(schoolService.getOne(sch_id)==null){
            errors.rejectValue(name,"NotListed.assignForm.schId");
            return false;
        }
        else {
            return true;
        }

    }

    private boolean validDistance(String distance, String name){
        try
        {
            Float dist = Float.parseFloat(distance);
            if(dist <= 0 || dist>100){
                errors.rejectValue(name,"Invalid.assignForm.distance");
                return false;
            }
            else {
                return true;
            }

        }
        catch( Exception ex)
        {
            errors.rejectValue(name,"Invalid.assignForm.distance");
            return false;
        }

    }

    private String calculateMark(String distance){
        int mark =0;
        Float dist = Float.parseFloat(distance);
        int Dist = Math.round(dist);

        if(dist<=1){
            mark=20;
        }

        else if(dist<=10){
            mark=20-Dist;
        }
        else{
            mark=5;
        }

       return String.valueOf(mark) ;

    }
}
