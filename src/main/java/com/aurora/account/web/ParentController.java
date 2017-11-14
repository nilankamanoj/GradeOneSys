package com.aurora.account.web;

import com.aurora.account.model.Parent;
import com.aurora.account.service.ParentService;
import com.aurora.account.validator.ParentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ParentController extends AbstractController
{
    @Autowired
    private ParentValidator parentValidator;
    @Autowired
    private ParentService parentService;

    @RequestMapping(value = "/addparent", method = RequestMethod.GET)
    public String addparent(Model model, String ok)
    {
        if(!setNav(model,6)){
            return "redirect:/changepass?force";
        }
        model.addAttribute("parentForm", new Parent());

        if (ok != null)
        {

            model.addAttribute("message", "<div class='alert alert-info'>parent added successfully.</div>");
        }

        return "addparent";
    }

    @RequestMapping(value = "/addparent", method = RequestMethod.POST)
    public String addparent(@ModelAttribute("parentForm") Parent parentForm, BindingResult bindingResult, Model model) 
    {
        
        parentValidator.validate(parentForm, bindingResult);

        if (bindingResult.hasErrors()) 
        {
            setNav(model,6);
            return "addparent";
        }
        
        parentService.saveApp(parentForm);
        setNav(model,6);
        return "redirect:/addparent?ok";
    }

    @RequestMapping("checkNIC")
    @ResponseBody
    public String  checkUser(String NIC){

        return String.valueOf(parentService.checkAvailability(NIC));
    }

}
