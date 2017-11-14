package com.aurora.account.web;

import com.aurora.account.Util.ContentGenerator;
import com.aurora.account.model.User;
import com.aurora.account.service.ActivityService;
import com.aurora.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class AbstractController 
{

    @Autowired
    protected ContentGenerator contentgen;
    @Autowired
    protected ActivityService activityService;
    @Autowired
    protected UserService userService;

    protected String getAuth()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) 
        {
            String currentUserName = authentication.getName();
            return currentUserName;
        }
        else
        {
            return null;
        }
    }

    protected Boolean setNav(Model model, int active)
    {

        String currentUserName=getAuth();
        User user = userService.findByUsername(currentUserName);
        if(activityService.checkActivated(String.valueOf(user.getId())) ){
            contentgen.setGen(currentUserName);
            String nav = contentgen.getNavbar(active);
            model.addAttribute("nav", nav);
            return true;
        }
        else {
            return false;
        }

    }

    protected void setProfile(Model model)
    {
        String profile = contentgen.getProfile();
        model.addAttribute("profile", profile);
    }

}
