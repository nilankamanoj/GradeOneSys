package com.aurora.account.web;

import com.aurora.account.model.AssignedApplicant;
import com.aurora.account.service.AssignedApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AssignedApplicantController extends AbstractController{

    @Autowired
    private AssignedApplicantService assignedApplicantService;

    @RequestMapping(value = "/assignapplicant", method = RequestMethod.GET)
    public String assignApplicant(Model model, String ok){
        model.addAttribute("assignForm",new AssignedApplicant());
        setNav(model,4);

        if (ok != null)
        {
            setNav(model, 4);
            model.addAttribute("message", "<div class='alert alert-info'>Assigned successfully.</div>");
        }

        return "assignapplicant";

    }
    //@RequestMapping(value = "/assignapplicant", method = RequestMethod.POST)

    @RequestMapping("checkAssignId")
    @ResponseBody
    public String  checkUser(String application_id){

        return String.valueOf(assignedApplicantService.checkAvailability(application_id));
    }



}
