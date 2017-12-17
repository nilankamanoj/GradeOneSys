package com.aurora.account.web;

import com.aurora.account.model.Interviewee;
import com.aurora.account.service.IntervieweeService;
import com.aurora.account.validator.IntervieweeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InterviewController extends AbstractController{
    @Autowired
    private IntervieweeService intervieweeService;
    @Autowired
    private IntervieweeValidator intervieweeValidator;

    @RequestMapping(value = "/interview", method = RequestMethod.GET)
    public String interview(Model model, String ok)
    {
        if (!setNav(model, 11))
        {
            return "redirect:/changepass?force";
        }
        
        model.addAttribute("intervieweeForm", new Interviewee());
        
        if (ok != null)
        {
            model.addAttribute("message", "<div class='alert alert-info'Interviewee marks added successfully.</div>");
        }


        return "interview";

    }
    @RequestMapping(value = "/interview", method = RequestMethod.POST)
    public String addMarks(@ModelAttribute("intervieweeForm") Interviewee intervieweeForm, BindingResult bindingResult, Model model) {
        
        
        intervieweeValidator.validate(intervieweeForm, bindingResult);
        setNav(model, 11);

        if (bindingResult.hasErrors()){
            return "interview";
        } else{
            intervieweeService.saveInterviewee(intervieweeForm);
            return "redirect:/interview?ok";
        }
    }
}