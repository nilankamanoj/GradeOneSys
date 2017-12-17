package com.aurora.account.model;

public class Interviewee {
    
    private int application_id;
    private final int selected_sch_id;
    private double result_interview;
    private final int interviewer;

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
    
    public Interviewee(int interviewer_id, int sch_id){
        this.interviewer=interviewer_id;
        this.selected_sch_id=sch_id;    
    }
    
    
    @Override
    public String toString(){
        return ("('"+application_id+"',"+selected_sch_id+","+result_interview+","+interviewer+"')");
    }
}
