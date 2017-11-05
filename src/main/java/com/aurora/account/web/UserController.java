package com.aurora.account.web;

import com.aurora.account.Util.ContentGenerator;
import com.aurora.account.model.User;
import com.aurora.account.model.Applicant;
import com.aurora.account.model.TempUser;
import com.aurora.account.service.ApplicantService;
import com.aurora.account.service.SecurityService;
import com.aurora.account.service.UserService;
import com.aurora.account.validator.ApplicationValidator;
import com.aurora.account.validator.ChangePassValidator;
import com.aurora.account.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private ContentGenerator contentgen;
    @Autowired
    private UserService userService;
    @Autowired
    private ChangePassValidator changePassValidator;
        
    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private ApplicationValidator appValidator;
    
    @Autowired
    private ApplicantService appService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model, String ok) {
        model.addAttribute("userForm", new User());
        if (ok != null){
            model.addAttribute("message", "user added successfully.");
        }
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);
        return "redirect:/registration?ok";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
        String currentUserName = authentication.getName();
        
        
      //  contentgen=new ContentGenerator(currentUserName);
        contentgen.setGen(currentUserName);
        String nav=contentgen.getNavbar();
        model.addAttribute("nav", nav);
    }
        return "welcome";
    }
     @RequestMapping(value = "/addapplication", method = RequestMethod.GET)
     public String addapplication(Model model, String ok){
         model.addAttribute("applicantForm", new Applicant());
         if (ok != null){
            model.addAttribute("message", "application added successfully.");
        }
         return "addapplication";
     }
    @RequestMapping(value = "/addapplication", method = RequestMethod.POST)
    public String addapplication(@ModelAttribute("applicantForm") Applicant applicantForm, BindingResult bindingResult, Model model) {
       // userValidator.validate(applicantForm, bindingResult);
      appValidator.validate(applicantForm, bindingResult);
    if (bindingResult.hasErrors()) {
            return "addapplication";
       }

       appService.saveApp(applicantForm);
        return "redirect:/addapplication?ok";
    }
    
    
    @RequestMapping(value = "/changepass", method = RequestMethod.GET)
    public String changepass(Model model, String ok) {
        model.addAttribute("changeForm", new TempUser());
        if (ok != null){
            model.addAttribute("message", "password changed successfully.");
        }
        return "changepass";
    }

    
    @RequestMapping(value = "/changepass", method = RequestMethod.POST)
    public String changepass(@ModelAttribute("changeForm") TempUser changeForm, BindingResult bindingResult, Model model) {
        User authUser = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
        String currentUserName = authentication.getName();
        authUser=userService.findByUsername(currentUserName);
        User tempUser=new User();
        
        changePassValidator.validate(changeForm, authUser, bindingResult);
         if (bindingResult.hasErrors()) {
            return "changepass";
       }
        
        tempUser.setUsername("tempUser");
        tempUser.setOccupation(authUser.getOccupation());
        tempUser.setPassword(changeForm.getPassword());
        tempUser.setPasswordConfirm(changeForm.getPasswordConfirm());
        tempUser.setId(authUser.getId());
        tempUser.setUsername(authUser.getUsername());
        
        userService.save(tempUser);
        

        }

        return "redirect:/changepass?ok";
    }
}
