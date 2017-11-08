
package com.aurora.account.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Dilshan Navodya
 */
@Entity
@Table(name = "school")
public class School{
    @Id
    private String sch_id;    
    private String name;
    private String province;
    private String district;
    private String division;
    private String eligible_count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getEligible_count() {
        return eligible_count;
    }

    public void setEligible_count(String eligible_count) {
        this.eligible_count = eligible_count;
    }

    public String getSch_id() {
        return sch_id;
    }

    public void setSch_id(String sch_id) {
        this.sch_id = sch_id;
    }
    @Override
    public String toString(){
        return("('"+sch_id+"','"+name+"','"+division+"','"+district+"','"+province+"','"+eligible_count+"')");

    }
}
