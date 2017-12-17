package com.aurora.account.model;

public class Interviewee {
    
    private int application_id;
    private int selected_sch_id;
    private double result_interview;
    private int interviewer;

    public void setSelected_sch_id(int selected_sch_id) {
        this.selected_sch_id = selected_sch_id;
    }

    public void setInterviewer(int interviewer) {
        this.interviewer = interviewer;
    }

    public int getApplication_id() {
        return application_id;
    }

    public void setApplication_id(int application_id) {
        this.application_id = application_id;
    }

    public int getSelected_sch_id() {
        return selected_sch_id;
    }

    public double getResult_interview() {
        return result_interview;
    }

    public void setResult_interview(double result_interview) {
        this.result_interview = result_interview;
    }

    public int getInterviewer() {
        return interviewer;
    }
    
    
    
    @Override
    public String toString(){
        return ("('"+application_id+"',"+selected_sch_id+","+result_interview+","+interviewer+"')");
    }
}
