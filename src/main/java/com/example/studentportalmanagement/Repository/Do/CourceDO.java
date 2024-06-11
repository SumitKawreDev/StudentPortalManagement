package com.example.studentportalmanagement.Repository.Do;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "cource")
public class CourceDO {

    @Id
    @Column(name = "cource_id")
    public int courceId;
    @Column(name = "cource_code")
    public int courceCode;
    @Column(name = "cource_name")
    public String cource_name;
    @Column(name = "branch")
    public String branch;
    @Column(name = "cource_details")
    public String courceDetails;
    @Column(name = "cource_year")
    public int courceYear;

    public int getCourceId() {
        return courceId;
    }

    public void setCourceId(int courceId) {
        this.courceId = courceId;
    }

    public int getCourceCode() {
        return courceCode;
    }

    public void setCourceCode(int courceCode) {
        this.courceCode = courceCode;
    }

    public String getCource_name() {
        return cource_name;
    }

    public void setCource_name(String cource_name) {
        this.cource_name = cource_name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCourceDetails() {
        return courceDetails;
    }

    public void setCourceDetails(String courceDetails) {
        this.courceDetails = courceDetails;
    }

    public int getCourceYear() {
        return courceYear;
    }

    public void setCourceYear(int courceYear) {
        this.courceYear = courceYear;
    }
}
