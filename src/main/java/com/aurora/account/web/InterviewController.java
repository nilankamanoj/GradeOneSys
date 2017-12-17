package com.aurora.account.web;

import com.aurora.account.model.Interviewee;
import com.aurora.account.model.Interviewer;
import com.aurora.account.model.User;
import com.aurora.account.service.IntervieweeService;
import com.aurora.account.service.InterviewerService;
import com.aurora.account.service.UserService;
import com.aurora.account.validator.IntervieweeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InterviewController extends AbstractController{
    @Autowired
    private IntervieweeService intervieweeService;
    @Autowired
    private IntervieweeValidator intervieweeValidator;
    @Autowired
    private UserService userService;
    @Autowired
    private InterviewerService interviewerService;

    @RequestMapping(value = "/interview", method = RequestMethod.GET)
    public String interview(Model model, String ok)
    {
        if (!setNav(model, 11))
        {
            return "redirect:/changepass?force";
        }
        User auth = userService.findByUsername(super.getAuth());
        Interviewer interviewer = interviewerService.getOne(Long.toString(auth.getId()));
        Interviewee interviewee = new Interviewee();
        interviewee.setInterviewer(interviewer.getUid());
        interviewee.setSelected_sch_id(interviewer.getSch());
        model.addAttribute("interviewee", interviewee);
        model.addAttribute("school",interviewee.getSelected_sch_id());
        
        if (ok != null)
        {
            model.addAttribute("message", "<div class='alert alert-info'Interviewee marks added successfully.</div>");
        }


        return "interview";

    }
    @RequestMapping(value = "/interview", method = RequestMethod.POST)
    public String addMarks(@ModelAttribute("interviewee") Interviewee intervieweeForm, BindingResult bindingResult, Model model) {
        User auth = userService.findByUsername(super.getAuth());
        Interviewer interviewer = interviewerService.getOne(Long.toString(auth.getId()));
        intervieweeForm.setInterviewer(interviewer.getUid());
        intervieweeForm.setSelected_sch_id(interviewer.getSch());
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