package com.aurora.account.web;

import com.aurora.account.Util.ContentGenerator;
import com.aurora.account.model.Applicant;
import com.aurora.account.model.Parent;
import com.aurora.account.model.School;
import com.aurora.account.model.User;
import com.aurora.account.service.ApplicantService;
import com.aurora.account.service.ParentService;
import com.aurora.account.service.SchoolService;
import com.aurora.account.service.UserService;
import com.aurora.account.validator.ApplicationValidator;
import com.aurora.account.validator.ParentValidator;
import com.aurora.account.validator.SchoolValidator;
import java.util.List;
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
public class ActivityController {
    @Autowired
    private ContentGenerator contentgen;
    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationValidator appValidator;
    @Autowired
    private ApplicantService appService;
    @Autowired
    private SchoolValidator schoolValidator;
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private ParentValidator parentValidator;
    @Autowired
    private ParentService parentService;


     @RequestMapping(value = "/addapplication", method = RequestMethod.GET)
     public String addapplication(Model model, String ok){
         model.addAttribute("applicantForm", new Applicant());
         setNav(model,2);
         if (ok != null){
             setNav(model, 2);
            model.addAttribute("message", "<div class='alert alert-info'>application added successfully.</div>");
        }
         return "addapplication";
     }
     
    @RequestMapping(value = "/addapplication", method = RequestMethod.POST)
    public String addapplication(@ModelAttribute("applicantForm") Applicant applicantForm, BindingResult bindingResult, Model model) {
       // userValidator.validate(applicantForm, bindingResult);
      appValidator.validate(applicantForm, bindingResult);
    if (bindingResult.hasErrors()) {
        setNav(model, 2);
            return "addapplication";
       }

       appService.saveApp(applicantForm);
        return "redirect:/addapplication?ok";
    }
    
    
    @RequestMapping(value = "/viewusers", method = RequestMethod.GET)
    public String viewusers(Model model) {
        
        setNav(model,3);
        
        String content="<form id='contact' method='POST'  >";
        List<User> users = userService.getAll();
        for(User user : users){
            contentgen.setGen(user.getUsername());
            content+=(contentgen.getProfile()+"<hr><br>");
        }
        content+="</form>";
        model.addAttribute("content", content);
        return "viewusers";
    }
    
 
    @RequestMapping(value = "/addschool", method = RequestMethod.GET)
     public String addschool(Model model, String ok){
         model.addAttribute("schoolForm", new School());
        setNav(model, 5);
         if (ok != null){
             
            model.addAttribute("message", "<div class='alert alert-info'>school added successfully.</div>");
        }
         return "addschool";
     }
     
    @RequestMapping(value = "/addschool", method = RequestMethod.POST)
    public String addschool(@ModelAttribute("schoolForm") School schoolForm, BindingResult bindingResult, Model model) {
        schoolValidator.validate(schoolForm, bindingResult);
    if (bindingResult.hasErrors()) {
        setNav(model, 5);
        return "addschool";
       }

       schoolService.saveApp(schoolForm);
        setNav(model, 5);
        return "redirect:/addschool?ok";
    }
    @RequestMapping(value = "/addparent", method = RequestMethod.GET)
     public String addparent(Model model, String ok){
        model.addAttribute("parentForm", new Parent());
        
        if (ok != null){
             
            model.addAttribute("message", "<div class='alert alert-info'>parent added successfully.</div>");
        }
         return "addparent";
     }
     
    @RequestMapping(value = "/addparent", method = RequestMethod.POST)
    public String addparent(@ModelAttribute("parentForm") Parent parentForm, BindingResult bindingResult, Model model) {
       // userValidator.validate(applicantForm, bindingResult);
        parentValidator.validate(parentForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "addparent";
        }
        parentService.saveApp(parentForm);
        return "redirect:/addparent?ok";
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
    public void setNav(Model model, int active){
        String currentUserName=getAuth();
        contentgen.setGen(currentUserName);
        String nav=contentgen.getNavbar(active);
        model.addAttribute("nav", nav);
    }
    public void setProfile(Model model){
        String profile = contentgen.getProfile();
        model.addAttribute("profile", profile);
    }
}
