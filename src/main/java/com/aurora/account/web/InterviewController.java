package com.aurora.account.web;

import com.aurora.account.model.Interviewee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InterviewController extends AbstractController{

    @RequestMapping(value = "/interview", method = RequestMethod.GET)
    public String interview(Model model)
    {
        if (!setNav(model, 11))
        {
            return "redirect:/changepass?force";
        }
        model.addAttribute("interviwee", new Interviewee());

        return "interview";

    }
}
