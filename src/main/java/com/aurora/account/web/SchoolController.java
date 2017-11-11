package com.aurora.account.web;

import com.aurora.account.model.School;
import com.aurora.account.service.SchoolService;
import com.aurora.account.validator.SchoolValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SchoolController extends AbstractController
{
    @Autowired
    private SchoolValidator schoolValidator;
    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/addschool", method = RequestMethod.GET)
    public String addschool(Model model, String ok)
    {
        model.addAttribute("schoolForm", new School());
        model.addAttribute("idList",schoolService.getJavaScriptIds());
        setNav(model, 5);

        if (ok != null)
        {

            model.addAttribute("message", "<div class='alert alert-info'>school added successfully.</div>");
        }

        return "addschool";
    }

    @RequestMapping(value = "/addschool", method = RequestMethod.POST)
    public String addschool(@ModelAttribute("schoolForm") School schoolForm, BindingResult bindingResult, Model model) 
    {
        schoolValidator.validate(schoolForm, bindingResult);

        if (bindingResult.hasErrors()) 
        {
            setNav(model, 5);
            return "addschool";
        }

        schoolService.saveApp(schoolForm);
        setNav(model, 5);
        return "redirect:/addschool?ok";
    }
}
