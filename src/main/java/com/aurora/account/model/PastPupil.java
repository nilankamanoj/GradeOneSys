package com.aurora.account.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="past_pupil")
public class PastPupil {
    @Id
    private String student_id;
    private String school_id;
    private String no_of_classes;
    private String period;
    private String achievements;
    private String past_pupil_member_id;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
        
    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }
    
    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getNo_of_classes() {
        return no_of_classes;
    }

    public void setNo_of_classes(String no_of_classes) {
        this.no_of_classes = no_of_classes;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public String getPast_pupil_member_id() {
        return past_pupil_member_id;
    }

    public void setPast_pupil_member_id(String past_pupil_member_id) {
        this.past_pupil_member_id = past_pupil_member_id;
    }
    
    @Override
    public String toString(){
        return ("('"+id+"',"+student_id+","+school_id+","+no_of_classes+",'"+period+"','"+achievements+"','"+past_pupil_member_id+"')");
    }
}
