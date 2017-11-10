package com.aurora.account.validator;

import com.aurora.account.model.PastPupil;
import com.aurora.account.service.PastPupilService;
import com.aurora.account.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PastPupilValidator implements Validator{
    @Autowired
    PastPupilService pastPupilService;
    @Autowired
    SchoolService schoolService;

    @Override
    public boolean supports(Class<?> aClass) {
        return PastPupil.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PastPupil pastPupil = (PastPupil) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "school_id", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "student_id", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "no_of_classes", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "period", "NotEmpty");

        String id = pastPupil.getId().trim();
        String school_id = pastPupil.getSchool_id().trim();
        String student_id = pastPupil.getStudent_id().trim();
        String ppm_id = pastPupil.getPast_pupil_member_id().trim();
        String achievements = pastPupil.getAchievements().trim();
        String period = pastPupil.getPeriod().trim();
        String no_of_classes = pastPupil.getNo_of_classes().trim();

        if (!(id.length() == 10 && ((id.endsWith("V") || id.endsWith("v")))
                && id.subSequence(0,8).chars().allMatch(Character::isDigit))){
            errors.rejectValue("id", "Invalid.pastPupilForm.id");
        }
        else if(pastPupilService.getOne(id)!=null){
            errors.rejectValue("id", "Dupplicate.pastPupilForm.id");

        }
        if (school_id.length()>0 && !((school_id.chars().allMatch(Character::isDigit)) && (schoolService.getOne(school_id)!=null))) {
            errors.rejectValue("school_id", "Invalid.pastPupilForm.school_id");
        }
        if (achievements.length()>0 && achievements.chars().allMatch(Character::isDigit)){
            errors.rejectValue("achievements", "Invalid.pastPupilForm.achievements");
        }
        if (student_id.length()>0 && !(student_id.chars().allMatch(Character::isDigit))){
            errors.rejectValue("student_id", "Invalid.pastPupilForm.student_id");
        }
        if (no_of_classes.length()>0 && !(no_of_classes.chars().allMatch(Character::isDigit))){
            errors.rejectValue("no_of_classes", "Invalid.pastPupilForm.no_of_classes");
        }
        if (period.length()>0 && period.contains("-")){
            String[] p = period.split("-");
            p[0] = p[0].trim();
            p[1] = p[1].trim();
            if (!(p[0].length()==4 && p[1].length()==4 && p[0].chars().allMatch(Character::isDigit)
                    && p[1].chars().allMatch(Character::isDigit) && (Integer.parseInt(p[0])<Integer.parseInt(p[1])))){
                errors.rejectValue("period", "Invalid.pastPupilForm.period");
            }
        }else{
            errors.rejectValue("period", "Invalid.pastPupilForm.period");
        }


    }


}