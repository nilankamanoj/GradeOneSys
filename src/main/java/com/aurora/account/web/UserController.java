package com.aurora.account.web;

import com.aurora.account.model.Activity;
import com.aurora.account.model.TempUser;
import com.aurora.account.model.User;
import com.aurora.account.service.ActivityService;
import com.aurora.account.service.ApplicantService;
import com.aurora.account.service.UserService;
import com.aurora.account.validator.ChangePassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController extends AbstractController
{

    @Autowired
    private UserService userService;
    @Autowired
    private ChangePassValidator changePassValidator;
    @Autowired
    private ActivityService activityService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout)
    {
        if (error != null)
        {
            model.addAttribute("error", "Invalid Credentials!.");
        }

        if (logout != null)
        {
            model.addAttribute("message", "<div class='alert alert-info'>You have been logged out successfully.</div>");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model, String error403,String error404)
    {
        if(!setNav(model,0)){
            return "redirect:/changepass?force";
        }

        if(error403!=null)
        {
        model.addAttribute("message",contentgen.get403());
        }
        
        else if(error404!=null)
        {
            model.addAttribute("message",contentgen.get404());
        }

        else
        {
            model.addAttribute("message",contentgen.getNormal());
        }

        return "welcome";
    }
    
    @RequestMapping(value = "/changepass", method = RequestMethod.GET)
    public String changepass(Model model, String ok,String force)
    {
        model.addAttribute("changeForm", new TempUser());
        if(force!=null){
            model.addAttribute("message","You must change password!");
        }
        else if(!setNav(model,4)){
            return "redirect:/changepass?force";
        }

        if (ok != null)
        {
            setNav(model,4);
            model.addAttribute("message", "<div class='alert alert-info'>password changed successfully.</div>");
        }

        return "changepass";
    }

    
    @RequestMapping(value = "/changepass", method = RequestMethod.POST)
    public String changepass(@ModelAttribute("changeForm") TempUser changeForm, BindingResult bindingResult, Model model)
    {
        User authUser = null;
        String currentUserName=getAuth();
        authUser=userService.findByUsername(currentUserName);
        User tempUser=new User();
        changePassValidator.validate(changeForm, authUser, bindingResult);

        if (bindingResult.hasErrors()) 
        {
            setNav(model,4);
            return "changepass";
        }
        
        tempUser.setUsername("tempUser");
        tempUser.setOccupation(authUser.getOccupation());
        tempUser.setPassword(changeForm.getPassword());
        tempUser.setPasswordConfirm(changeForm.getPasswordConfirm());
        tempUser.setId(authUser.getId());
        tempUser.setUsername(authUser.getUsername());
        Activity activity=new Activity();
        activity.setUser_id(tempUser.getId());
        activity.setActivity("password changed");
        userService.save(tempUser);
        activityService.saveActivity(activity);

               
        return "redirect:/changepass?ok";
    }
    
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model) 
    {

        if(!setNav(model,4)){
            return "redirect:/changepass?force";
        }
        setProfile(model);
        
        return "profile";
    }

    @RequestMapping(value = "/viewusers", method = RequestMethod.GET)
    public String viewusers(Model model) 
    {

        if(!setNav(model,3)){
            return "redirect:/changepass?force";
        }
        String content="<form id='contact' method='POST'  >";
        List<User> users = userService.getAll();

        for(User user : users)
        {
            contentgen.setGen(user.getUsername());
            content+=(contentgen.getProfile()+"<hr><br>");
        }

        content+="</form>";
        model.addAttribute("content", content);
        
        return "viewusers";
    }

    @RequestMapping("checkUserName")
    @ResponseBody
    public String  checkUser(String username){

        return String.valueOf(userService.availabaleUserName(username));
    }



}
