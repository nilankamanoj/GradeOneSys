package com.aurora.account.web;

import com.aurora.account.Util.ContentGenerator;
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

    protected void setNav(Model model, int active)
    {
        String currentUserName=getAuth();
        contentgen.setGen(currentUserName);
        String nav=contentgen.getNavbar(active);
        model.addAttribute("nav", nav);
    }

    protected void setProfile(Model model)
    {
        String profile = contentgen.getProfile();
        model.addAttribute("profile", profile);
    }

}
