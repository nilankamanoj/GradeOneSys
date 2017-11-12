package com.aurora.account.model;

public class AssignedApplicant {
    private String application_id;
    private  String nic;
    private String sch_id1;
    private String distance1;
    private String application_result1;

    private String sch_id2;
    private String distance2;
    private String application_result2;

    private String sch_id3;
    private String distance3;
    private String application_result3;

    private String sch_id4;
    private String distance4;
    private String application_result4;

    private String sch_id5;
    private String distance5;
    private String application_result5;


    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getSch_id1() {
        return sch_id1;
    }

    public void setSch_id1(String sch_id1) {
        this.sch_id1 = sch_id1;
    }

    public String getDistance1() {
        return distance1;
    }

    public void setDistance1(String distance1) {
        this.distance1 = distance1;
    }

    public String getApplication_result1() {
        return application_result1;
    }

    public void setApplication_result1(String application_result1) {
        this.application_result1 = application_result1;
    }

    public String getSch_id2() {
        return sch_id2;
    }

    public void setSch_id2(String sch_id2) {
        this.sch_id2 = sch_id2;
    }

    public String getDistance2() {
        return distance2;
    }

    public void setDistance2(String distance2) {
        this.distance2 = distance2;
    }

    public String getApplication_result2() {
        return application_result2;
    }

    public void setApplication_result2(String application_result2) {
        this.application_result2 = application_result2;
    }

    public String getSch_id3() {
        return sch_id3;
    }

    public void setSch_id3(String sch_id3) {
        this.sch_id3 = sch_id3;
    }

    public String getDistance3() {
        return distance3;
    }

    public void setDistance3(String distance3) {
        this.distance3 = distance3;
    }

    public String getApplication_result3() {
        return application_result3;
    }

    public void setApplication_result3(String application_result3) {
        this.application_result3 = application_result3;
    }

    public String getSch_id4() {
        return sch_id4;
    }

    public void setSch_id4(String sch_id4) {
        this.sch_id4 = sch_id4;
    }

    public String getDistance4() {
        return distance4;
    }

    public void setDistance4(String distance4) {
        this.distance4 = distance4;
    }

    public String getApplication_result4() {
        return application_result4;
    }

    public void setApplication_result4(String application_result4) {
        this.application_result4 = application_result4;
    }

    public String getSch_id5() {
        return sch_id5;
    }

    public void setSch_id5(String sch_id5) {
        this.sch_id5 = sch_id5;
    }

    public String getDistance5() {
        return distance5;
    }

    public void setDistance5(String distance5) {
        this.distance5 = distance5;
    }

    public String getApplication_result5() {
        return application_result5;
    }

    public void setApplication_result5(String application_result5) {
        this.application_result5 = application_result5;
    }



    public String toStringForApplicantParent(){
        return "('"+application_id+"','"+nic+"')";
    }

    public String toStringForAssignedApplicant1(){
        return "('"+application_id+"','"+sch_id1+"','"+distance1+"','"+application_result1+"')";
    }
    public String toStringForAssignedApplicant2(){
        return "('"+application_id+"','"+sch_id2+"','"+distance2+"','"+application_result2+"')";
    }
    public String toStringForAssignedApplicant3(){
        return "('"+application_id+"','"+sch_id3+"','"+distance3+"','"+application_result3+"')";
    }
    public String toStringForAssignedApplicant4(){
        return "('"+application_id+"','"+sch_id4+"','"+distance4+"','"+application_result4+"')";
    }
    public String toStringForAssignedApplicant5(){
        return "('"+application_id+"','"+sch_id5+"','"+distance5+"','"+application_result5+"')";
    }


}
