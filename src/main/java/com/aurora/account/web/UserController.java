package com.aurora.account.web;

import com.aurora.account.Util.ContentGenerator;
import com.aurora.account.model.Applicant;
import com.aurora.account.model.TempUser;
import com.aurora.account.model.User;
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
        setNav(model);
        if (ok != null){
            model.addAttribute("message", "<div class='alert alert-info'>user added successfully.</div>");
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
            model.addAttribute("message", "<div class='alert alert-info'>You have been logged out successfully.</div>");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model, String error403,String error404) {

        setNav(model);
        if(error403!=null){
            model.addAttribute("message","<form id='contact'><h1><div class='alert alert-info'>Requested Page Access Denied!.</div></h1><form>");
        }
        if(error404!=null){
            model.addAttribute("message","<form id='contact'><h1><div class='alert alert-info'>Requested Page Not Found!.</div></h1><form>");
        }
        return "welcome";
    }
     @RequestMapping(value = "/addapplication", method = RequestMethod.GET)
     public String addapplication(Model model, String ok){
         model.addAttribute("applicantForm", new Applicant());
         setNav(model);
         if (ok != null){
            model.addAttribute("message", "<div class='alert alert-info'>application added successfully.</div>");
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
        setNav(model);
        if (ok != null){
            model.addAttribute("message", "<div class='alert alert-info'>password changed successfully.</div>");
        }
        return "changepass";
    }

    
    @RequestMapping(value = "/changepass", method = RequestMethod.POST)
    public String changepass(@ModelAttribute("changeForm") TempUser changeForm, BindingResult bindingResult, Model model) {
        User authUser = null;
       String currentUserName=getAuth();
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
        

        
        return "redirect:/changepass?ok";
    }
    
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model) {
        
        setNav(model);
        setProfile(model);
        
        return "profile";
    }


    
    public String getAuth(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
        String currentUserName = authentication.getName();
        return currentUserName;
        }
        else{
            return null;
        }
    }
    public void setNav(Model model){
        String currentUserName=getAuth();
        contentgen.setGen(currentUserName);
        String nav=contentgen.getNavbar();
        model.addAttribute("nav", nav);
    }
    public void setProfile(Model model){
        String profile = contentgen.getProfile();
        model.addAttribute("profile", profile);
    }
}
