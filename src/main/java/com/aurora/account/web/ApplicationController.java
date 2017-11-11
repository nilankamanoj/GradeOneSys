package com.aurora.account.web;

import com.aurora.account.model.Applicant;
import com.aurora.account.service.ApplicantService;
import com.aurora.account.validator.ApplicationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationController extends AbstractController
{
    @Autowired
    private ApplicationValidator appValidator;
    @Autowired
    private ApplicantService appService;

    @RequestMapping(value = "/addapplication", method = RequestMethod.GET)
    public String addapplication(Model model, String ok)
    {
        model.addAttribute("applicantForm", new Applicant());
        model.addAttribute("idList",appService.getJavaScriptIds());
        setNav(model,2);

        if (ok != null)
        {
            setNav(model, 2);
            model.addAttribute("message", "<div class='alert alert-info'>application added successfully.</div>");
        }

        return "addapplication";
    }

    @RequestMapping(value = "/addapplication", method = RequestMethod.POST)
    public String addapplication(@ModelAttribute("applicantForm") Applicant applicantForm, BindingResult bindingResult, Model model) 
    {
        appValidator.validate(applicantForm, bindingResult);

        if (bindingResult.hasErrors()) 
        {
            setNav(model, 2);
            return "addapplication";
        }

        appService.saveApp(applicantForm);
        return "redirect:/addapplication?ok";
    }
}
