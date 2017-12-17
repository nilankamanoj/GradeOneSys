package com.aurora.account.validator;

import com.aurora.account.model.Interviewee;
import com.aurora.account.service.AssignedApplicantService;
import com.aurora.account.service.IntervieweeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class IntervieweeValidator implements Validator {
    @Autowired
    private AssignedApplicantService assAppServ;
    @Autowired
    private IntervieweeService intervieweeService;
    
    @Override
    public void validate(Object o, Errors errors) {
        
        Interviewee interviewee = (Interviewee) o;
        String sch_id = interviewee.getSelected_sch_id();
        String app_id = interviewee.getApplication_id(); 
        String mark = interviewee.getResult_interview();
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "application_id", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "result_interview", "NotEmpty");
        
        try {
            if ((Double.parseDouble(mark)>50) || (Double.parseDouble(mark)<0)){
                errors.rejectValue("result_interview", "Invalid.interviewee.mark");
            }
        } catch(Exception E){
            errors.rejectValue("result_interview", "Invalid.interviewee.mark");
        }
        
        
        if (assAppServ.availableCombSchApp(sch_id, app_id)){
            errors.rejectValue("application_id", "Invalid.interviewee.application");
        }
        
        if (intervieweeService.getInterviewee(app_id, sch_id)!=null){
            errors.rejectValue("application_id", "Duplicate.interviewee.application");
        }
        
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Interviewee.class.equals(aClass);
    }
    
}
