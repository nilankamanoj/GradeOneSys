package com.aurora.account.web;

import com.aurora.account.Util.MailMail;
import com.aurora.account.Util.PdfGenerator;
import com.aurora.account.model.Applicant;
import com.aurora.account.model.AssignedApplicant;
import com.aurora.account.model.EmailApplicant;
import com.aurora.account.service.AssignedApplicantService;
import com.aurora.account.service.EmailApplicantService;
import com.aurora.account.validator.AssignedApplicantValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AssignedApplicantController extends AbstractController {
    private float total;
    private float emails = 0;
    private float percentage = 0;
    private boolean invoked = false;

    @Autowired
    private AssignedApplicantService assignedApplicantService;
    @Autowired
    private AssignedApplicantValidator assignedApplicantValidator;
    @Autowired
    private EmailApplicantService emailApplicantService;


    @RequestMapping(value = "/assignapplicant", method = RequestMethod.GET)
    public String assignApplicant(Model model, String ok) {
        if (!setNav(model, 8)) {
            return "redirect:/changepass?force";
        }
        model.addAttribute("assignForm", new AssignedApplicant());

        if (ok != null) {
            setNav(model, 8);
            model.addAttribute("message", "<div class='alert alert-info'>Assigned successfully.</div>");
        }

        return "assignapplicant";

    }

    @RequestMapping(value = "/assignapplicant", method = RequestMethod.POST)
    public String assignApplicant(@ModelAttribute("assignForm") AssignedApplicant assignForm, BindingResult bindingResult, Model model) {
        assignedApplicantValidator.validate(assignForm, bindingResult);

        if (bindingResult.hasErrors()) {
            setNav(model, 8);
            return "assignapplicant";
        }
        assignedApplicantService.saveAssign(assignForm);
        return "redirect:assignapplicant?ok";
    }

    @RequestMapping(value = "/viewapplications", method = RequestMethod.GET)
    public String viewApplicant(Model model) {
        if (!setNav(model, 9)) {
            return "redirect:/changepass?force";
        }
        model.addAttribute("applicantForm", new Applicant());

        return "viewapplications";

    }

    @RequestMapping(value = "/viewapplications", method = RequestMethod.POST)
    public String viewApplicant(@ModelAttribute("applicantForm") Applicant applicantForm, BindingResult bindingResult, Model model) {
        setNav(model, 9);


        return "viewapplications";

    }

    @RequestMapping(value = "/sendemailstoassign", method = RequestMethod.GET)
    public String sendEmail(Model model) {
        if (!setNav(model, 10)) {
            return "redirect:/changepass?force";
        }
        return "sendemailstoassign";
    }

    @RequestMapping(value = "/sendemailstoassign", method = RequestMethod.POST)
    public String proceedEmail(Model model) {
        if (!setNav(model, 10)) {
            return "redirect:/changepass?force";
        }

        return "sendemailstoassign";

    }

    @RequestMapping("checkAssignId")
    @ResponseBody
    public String checkUser(String application_id) {

        return String.valueOf(assignedApplicantService.checkAvailability(application_id));
    }

    @RequestMapping("getEmail")
    @ResponseBody
    public String checkEmail(String application_id) {
        EmailApplicant emailApplicant = emailApplicantService.getOne(application_id);
        return String.valueOf(emailApplicant.getEmail());
    }

    @RequestMapping("getPercentage")
    @ResponseBody
    public String getPercentage() {

        sendEmail();

        return String.valueOf(percentage);
    }

    @RequestMapping("checkPercentage")
    @ResponseBody
    public String checkPercentage() {

        return String.valueOf(percentage);
    }

    @RequestMapping("checkResults")
    @ResponseBody
    public String checkResult() {
        String results = "";
        results+=String.valueOf((int)total);
        results+=(","+String.valueOf((int)emails));
        results+=(","+String.valueOf((int)total-(int)emails));


return results;

    }

    public void sendEmail() {
        if (!invoked) {
            invoked = true;
            List<String> emailApps = emailApplicantService.getIdList();
            this.total = emailApps.size();
            float proceed = 0;
            MailMail mailMail = new MailMail();
            PdfGenerator pdfGenerator = new PdfGenerator();

            for (String app_id : emailApps) {
                if (mailMail.sendMail("nilankaeng16a@gmail.com", "Your Application Accepted" + app_id, emailApplicantService.getOne(app_id).getEmail())) {
                    proceed += 1;
                    percentage =(proceed/total)*100;
                    emails+=1;
                }
                else {
                    pdfGenerator.generatePdf(emailApplicantService.getOne(app_id).getEmail(),emailApplicantService.getOne(app_id).getApplicant().getId(),"assignForms/");
                    proceed += 1;
                    percentage =(proceed/total)*100;
                }
            }



        }
    }

    }




