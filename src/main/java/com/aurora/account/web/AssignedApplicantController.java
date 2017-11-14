package com.aurora.account.web;

import com.aurora.account.Util.MailMail;
import com.aurora.account.model.Applicant;
import com.aurora.account.model.AssignedApplicant;
import com.aurora.account.model.EmailApplicant;
import com.aurora.account.service.AssignedApplicantService;
import com.aurora.account.service.EmailApplicantService;
import com.aurora.account.validator.AssignedApplicantValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AssignedApplicantController extends AbstractController{

    @Autowired
    private AssignedApplicantService assignedApplicantService;
    @Autowired
    private AssignedApplicantValidator assignedApplicantValidator;
@Autowired
private EmailApplicantService emailApplicantService;
    @RequestMapping(value = "/assignapplicant", method = RequestMethod.GET)
    public String assignApplicant(Model model, String ok){
        if(!setNav(model,8)){
            return "redirect:/changepass?force";
        }
        model.addAttribute("assignForm",new AssignedApplicant());

        if (ok != null)
        {
            setNav(model, 8);
            model.addAttribute("message", "<div class='alert alert-info'>Assigned successfully.</div>");
        }

        return "assignapplicant";

    }
    @RequestMapping(value = "/assignapplicant", method = RequestMethod.POST)
    public String assignApplicant(@ModelAttribute("assignForm") AssignedApplicant assignForm, BindingResult bindingResult, Model model){
        assignedApplicantValidator.validate(assignForm,bindingResult);

        if (bindingResult.hasErrors())
        {
            setNav(model, 8);
            return "assignapplicant";
        }
        assignedApplicantService.saveAssign(assignForm);
        return "redirect:assignapplicant?ok";
    }

    @RequestMapping(value = "/viewapplications", method = RequestMethod.GET)
    public String viewApplicant(Model model){
        if(!setNav(model,9)){
            return "redirect:/changepass?force";
        }
        model.addAttribute("applicantForm", new Applicant());

        return "viewapplications";

    }

    @RequestMapping("checkAssignId")
    @ResponseBody
    public String  checkUser(String application_id){

        return String.valueOf(assignedApplicantService.checkAvailability(application_id));
    }

    @RequestMapping("getEmail")
    @ResponseBody
    public String  checkEmail(String application_id){
        EmailApplicant emailApplicant = emailApplicantService.getOne(application_id);
        //MailMail mailMail=new MailMail();
        //mailMail.sendMail("nilankaeng16a@gmail.com","Your Application Accepted",emailApplicant.getEmail());
        return String.valueOf(emailApplicant.getEmail());
    }



}
