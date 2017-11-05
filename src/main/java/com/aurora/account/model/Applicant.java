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
    private String initials;
    private String dob;
    private String gender;
    private String religion;
    private String age;
    private String district;
    private String div_sec;
    private String div_grama;
    private String electro_cert;
    private String grama_cert;
    private int appResult=0;

    public int getAppResult() {
        return appResult;
    }

    public void setAppResult(int appResult) {
        this.appResult = appResult;
    }

    public String getElectro_cert() {
        return electro_cert;
    }

    public void setElectro_cert(String electro_cert) {
        this.electro_cert = electro_cert;
        if(electro_cert!=null){
            appResult+=20;
        }
    }

    public String getGrama_cert() {
        return grama_cert;
    }

    public void setGrama_cert(String grama_cert) {
        this.grama_cert = grama_cert;
        if(grama_cert!=null){
            appResult+=10;
        }
    }
    

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    
    
   //private Database database ;


    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
        
        
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getDiv_sec() {
        return div_sec;
    }

    public void setDiv_sec(String div_sec) {
        this.div_sec = div_sec;
    }

    public String getDiv_grama() {
        return div_grama;
    }

    public void setDiv_grama(String div_grama) {
        this.div_grama = div_grama;
    }
  

    
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
    /*
    public void saveApp(){
        
        DbConnection con=new DbConnection();
        JdbcTemplate stmt= con.getConnection();
        stmt.update("insert into applicant values('"+application_id+"','"+first_name+"','"+second_name+"','"+initials+"','"+dob+"','"+gender+"','"+religion+"','"+age+"','"+district+"','"+div_sec+"','"+div_grama+"','"+appResult+"')");
      
        ApplicantRepository appRepo=new ApplicantRepository();
        appRepo.saveObj(this);
       
    }
*/
    @Override
    public String toString(){
        return("('"+application_id+"','"+first_name+"','"+second_name+"','"+initials+"','"+dob+"','"+gender+"','"+religion+"','"+age+"','"+district+"','"+div_sec+"','"+div_grama+"','"+appResult+"')");
    }
    
}