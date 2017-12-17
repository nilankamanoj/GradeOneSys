package com.aurora.account.web;

import com.aurora.account.model.Interviewer;
import com.aurora.account.model.User;
import com.aurora.account.model.UserForm;
import com.aurora.account.service.InterviewerService;
import com.aurora.account.service.UserService;
import com.aurora.account.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationContoller extends AbstractController 
{
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserService userService;
    @Autowired
    private InterviewerService interviewerService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model, String ok) 
    {
        if(!setNav(model,1)){
            return "redirect:/changepass?force";
        }
        model.addAttribute("userForm", new UserForm());

        if (ok != null)
        {
            setNav(model,1);
            model.addAttribute("message", "<div class='alert alert-info'>user added successfully.</div>");
        }
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult, Model model)
    {
        User user=new User();
        user.setUsername(userForm.getUsername());
        user.setOccupation(userForm.getOccupation());
        user.setPassword(userForm.getPassword());
        user.setPasswordConfirm(userForm.getPasswordConfirm());

        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) 
        {
            setNav(model,1);
            return "registration";
        }

        userService.save(user);
        if(userForm.getOccupation().trim().equals("interviewer")){
           Interviewer interviewer=new Interviewer();
           interviewer.setSch(userForm.getSch());
           interviewer.setUid(Long.toString(userService.findByUsername(user.getUsername()).getId()));

           interviewerService.saveInterviwer(interviewer);
        }
        return "redirect:/registration?ok";
    }

}
