package com.aurora.account.web;

import com.aurora.account.model.PastPupil;
import com.aurora.account.service.PastPupilService;
import com.aurora.account.service.SchoolService;
import com.aurora.account.validator.PastPupilValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PastPupilController extends AbstractController
{
    @Autowired
    private PastPupilService pastPupilService;
    @Autowired
    private PastPupilValidator pastPupilValidator;
    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/addpastpupil", method = RequestMethod.GET)
    public String addPastPupil(Model model, String ok)
    {
        model.addAttribute("pastPupilForm", new PastPupil());
        model.addAttribute("idList",pastPupilService.getJavaScriptIds());
        model.addAttribute("schList",schoolService.getJavaScriptIds());

        if (ok != null)
        {
            model.addAttribute("message", "<div class='alert alert-info'>Past pupil details added successfully.</div>");
        }

        setNav(model, 7);
        return "addpastpupil";
    }

    @RequestMapping(value = "/addpastpupil", method = RequestMethod.POST)
    public String addPastPupil(@ModelAttribute("pastPupilForm") PastPupil pastPupilForm, BindingResult bindingResult, Model model)
    {
        pastPupilValidator.validate(pastPupilForm, bindingResult);
        setNav(model, 7);

        if (bindingResult.hasErrors())
        {
            return "addpastpupil";
        }
        else 
        {
            pastPupilService.savePastPupil(pastPupilForm);
            return "redirect:/addpastpupil?ok";
        }
    }
}
