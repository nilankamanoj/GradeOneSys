package com.aurora.account.model;

public class Interviewee {
    
    private String application_id;
    private String selected_sch_id;
    private String result_interview;
    private String interviewer;

    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }

    public String getSelected_sch_id() {
        return selected_sch_id;
    }

    public void setSelected_sch_id(String selected_sch_id) {
        this.selected_sch_id = selected_sch_id;
    }

    public String getResult_interview() {
        return result_interview;
    }

    public void setResult_interview(String result_interview) {
        this.result_interview = result_interview;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    
    
    
    @Override
    public String toString(){
        return ("('"+application_id+"',"+selected_sch_id+","+result_interview+","+interviewer+"')");
    }
}
