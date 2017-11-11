package com.aurora.account.web;

import com.aurora.account.model.User;
import com.aurora.account.service.UserService;
import com.aurora.account.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationContoller extends AbstractController 
{
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model, String ok) 
    {
        model.addAttribute("userForm", new User());
        setNav(model,1);

        if (ok != null)
        {
            setNav(model,1);
            model.addAttribute("message", "<div class='alert alert-info'>user added successfully.</div>");
        }
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) 
    {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) 
        {
            setNav(model,1);
            return "registration";
        }

        userService.save(userForm);
        return "redirect:/registration?ok";
    }

}
