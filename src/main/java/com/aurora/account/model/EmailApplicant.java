package com.aurora.account.model;

import java.util.ArrayList;

public class EmailApplicant {
    private Applicant applicant;
    private AssignedApplicant assignedApplicant;
    private Parent parent;
    private ArrayList<School> schools;

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public AssignedApplicant getAssignedApplicant() {
        return assignedApplicant;
    }

    public void setAssignedApplicant(AssignedApplicant assignedApplicant) {
        this.assignedApplicant = assignedApplicant;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public ArrayList<School> getSchools() {
        return schools;
    }

    public void setSchools(ArrayList<School> schools) {
        this.schools = schools;
    }

    public String getEmail(){
        String email="\n" +
                "\n" +
                "<h1>Application Form</h1>\n" +
                "<h2>Grade One Evaluation - Ministry Of Education</h2>\n" +
                "<p><i>Your application was added to the system successfully as following data.</i></p>\n" +
                "<hr>\n" +
                "<h3><font color=#003284>1.Applicant details</font></h3>\n" +
                "<table>\n" +
                "<tr><td><b>name </b></td><td>"+applicant.getInitials()+" "+applicant.getFirst_name()+" "+applicant.getSecond_name()+"</td></tr>\n" +
                "<tr><td><b>date of birth </b></td><td>"+applicant.getDob()+"</td></tr>\n" +
                "<tr><td><b>gender</b></td><td>"+applicant.getGender()+"</td></tr>\n" +
                "<tr><td><b>religion</b></td><td>"+applicant.getReligion()+"</td></tr>\n" +
                "<tr><td><b>district</b></td><td>"+applicant.getDistrict()+"</td></tr>\n" +
                "<tr><td><b>secretary div&nbsp</b></td><td>"+applicant.getDiv_sec()+"</td></tr>\n" +
                "<tr><td><b>grama div</b></td><td>"+applicant.getDiv_grama()+"</td></tr>\n" +
                "</table>\n" +
                "<hr>\n" +
                "<h3><font color=#003284>2.Guardian details</font></h3>\n" +
                "<table>\n" +
                "<tr><td><b>name </b></td><td>"+parent.getInitials()+" "+parent.getFirst_name()+" " +parent.getSecond_name()+"</td></tr>\n" +
                "<tr><td><b>NIC </b></td><td>"+parent.getNIC()+"</td></tr>\n" +
                "<tr><td><b>gender</b></td><td>"+parent.getGender()+"</td></tr>\n" +
                "<tr><td><b>occupation&nbsp</b></td><td>"+parent.getOccupation()+"</td></tr>\n" +
                "<tr><td><b>telphone</b></td><td>"+parent.getTelephone_no()+"</td></tr>\n" +
                "<tr><td><b>email</b></td><td>"+parent.getEmail()+"</td></tr>\n" +
                "</table>\n" +
                "<hr>\n" +
                "<h3><font color=#003284>3.Requested schools</font></h3>\n" +
                "<table>\n" +
                "<tr><th>school Id </th><th>Name</th></tr>\n" ;

                for(School school:schools){

                    email+="<tr><td>"+school.getSch_id()+" </td><td>"+school.getName()+"/"+school.getDivision()+"</td></tr>\n" ;
                }
                email+="</table>\n" +
                "<hr>\n" +
                "<p><font color=#5c0a66><i>thank you.</i></font></p>\n";
        email+="<center>\n" +
                "<p>powered by :</p>\n" +
                "<img width=100px height=auto src='https://github.com/nilankamanoj/GradeOneSys/blob/master/src/main/webapp/resources/images/Aurora-logo.png?raw=true'></img>\n" +
                "</center>";
        return email;
    }
}
