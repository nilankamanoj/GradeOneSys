package com.aurora.account.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "applicant")
public class Applicant {


    @Id
    private String application_id;    
    private String first_name;
    private String second_name;

    
    public String getId() {
        return application_id;
    }

    public void setId(String application_id) {
        this.application_id = application_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }
    
}