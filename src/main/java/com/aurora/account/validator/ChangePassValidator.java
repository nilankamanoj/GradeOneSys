package com.aurora.account.validator;

import com.aurora.account.model.TempUser;
import com.aurora.account.model.User;
import com.aurora.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ChangePassValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

  
    public void validate(TempUser tmp,User authUser, Errors errors) {
        
        if(!userService.verifyPassword(tmp, authUser)){
           errors.rejectValue("oldPass", "Diff.userForm.passwordOld");
            
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (tmp.getPassword().length() < 8 || tmp.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!tmp.getPasswordConfirm().equals(tmp.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }


    }

    @Override
    public void validate(Object o, Errors errors) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
