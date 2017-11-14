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
public class AssignedApplicantController extends AbstractController{

    private int percentage = 0;
    private boolean invoked =false;

    @Autowired
    private AssignedApplicantService assignedApplicantService;
    @Autowired
    private AssignedApplicantValidator assignedApplicantValidator;
@Autowired
private EmailApplicantService emailApplicantService;
;
    @RequestMapping(value = "/assignapplicant", method = RequestMethod.GET)
    public String assignApplicant(Model model, String ok){
        if(!setNav(model,8)){
            return "redirect:/changepass?force";
        }
        model.addAttribute("assignForm",new AssignedApplicant());

        if (ok != null)
        {
            setNav(model, 8);
            model.addAttribute("message", "<div class='alert alert-info'>Assigned successfully.</div>");
        }

        return "assignapplicant";

    }
    @RequestMapping(value = "/assignapplicant", method = RequestMethod.POST)
    public String assignApplicant(@ModelAttribute("assignForm") AssignedApplicant assignForm, BindingResult bindingResult, Model model){
        assignedApplicantValidator.validate(assignForm,bindingResult);

        if (bindingResult.hasErrors())
        {
            setNav(model, 8);
            return "assignapplicant";
        }
        assignedApplicantService.saveAssign(assignForm);
        return "redirect:assignapplicant?ok";
    }

    @RequestMapping(value = "/viewapplications", method = RequestMethod.GET)
    public String viewApplicant(Model model){
        if(!setNav(model,9)){
            return "redirect:/changepass?force";
        }
        model.addAttribute("applicantForm", new Applicant());

        return "viewapplications";

    }

    @RequestMapping(value = "/viewapplications", method = RequestMethod.POST)
    public String viewApplicant(@ModelAttribute("applicantForm") Applicant applicantForm, BindingResult bindingResult, Model model){
        setNav(model,9);


        return "viewapplications";

    }

    @RequestMapping(value="/sendemailstoassign", method = RequestMethod.GET)
    public String sendEmail(Model model){
        if(!setNav(model,4)){
            return "redirect:/changepass?force";
        }
        //model.addAttribute("button","<button class='button special' type='submit'>Proceed</button>");
        model.addAttribute("progress","    <div class=\"progress\">\n" +
                "        <div class=\"progress-bar progress-bar-striped active\" role=\"progressbar\" aria-valuenow=\"0\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 0%;\">\n" +
                "            <span class = \"current-value\">0%</span>\n" +
                "        </div>\n" +
                "</div>");
        return "sendemailstoassign";
    }

    @RequestMapping(value="/sendemailstoassign", method = RequestMethod.POST)
    public String proceedEmail(Model model){



        return "sendemailstoassign";

    }

    @RequestMapping("checkAssignId")
    @ResponseBody
    public String  checkUser(String application_id){

        return String.valueOf(assignedApplicantService.checkAvailability(application_id));
    }

    @RequestMapping("getEmail")
    @ResponseBody
    public String  checkEmail(String application_id){
        EmailApplicant emailApplicant = emailApplicantService.getOne(application_id);
       // MailMail mailMail=new MailMail();
       // mailMail.sendMail("nilankaeng16a@gmail.com","Your Application Accepted",emailApplicant.getEmail());
      //  PdfGenerator pdfGenerator = new PdfGenerator();
      //  pdfGenerator.generatePdf(emailApplicant.getEmail(),emailApplicant.getApplicant().getId(),"assignForms/");
        return String.valueOf(emailApplicant.getEmail());
    }

    @RequestMapping("getPercentage")
    @ResponseBody
    public String  getPercentage(){

            sendEmail();

        return String.valueOf(percentage);
    }

    @RequestMapping("checkPercentage")
    @ResponseBody
    public String  checkPercentage(){

        return String.valueOf(percentage);
    }

    public void sendEmail(){
        if(!invoked) {
            invoked = true;
            List<String> emailApps = emailApplicantService.getIdList();
            int total = emailApps.size();
            int proceed = 0;
            MailMail mailMail = new MailMail();
            // ;
            for (String app_id : emailApps) {
                if (mailMail.sendMail("nilankaeng16a@gmail.com", "Your Application Accepted" + app_id, emailApplicantService.getOne(app_id).getEmail())) {
                    proceed += 1;
                    percentage += ((proceed / total) * 100);
                }
            }
        }

    }



}
