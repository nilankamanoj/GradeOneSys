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
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("checkId")
    @ResponseBody
    public String  checkUser(String id){

        return String.valueOf(pastPupilService.checkAvailability(id));
    }

    @RequestMapping("checkSchStuCombination")
    @ResponseBody
    public String  checkSchStu(String sch_id, String stu_id){

        return String.valueOf(pastPupilService.availbleCombSchStu(sch_id, stu_id));
    }

    @RequestMapping("checkSchMemCombination")
    @ResponseBody
    public String  checkSchMem(String sch_id,String mem_id){

        return String.valueOf(pastPupilService.availbleCombSchMem(sch_id, mem_id));
    }
}
