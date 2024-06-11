package com.example.studentportalmanagement.Model;

public class Cource {
    public int courceId;
    public int courceCode;
    public String cource_name;
    public String branch;
    public String courceDetails;

    public int getCourceYear() {
        return courceYear;
    }

    public void setCourceYear(int courceYear) {
        this.courceYear = courceYear;
    }

    public String getCourceDetails() {
        return courceDetails;
    }

    public void setCourceDetails(String courceDetails) {
        this.courceDetails = courceDetails;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCource_name() {
        return cource_name;
    }

    public void setCource_name(String cource_name) {
        this.cource_name = cource_name;
    }

    public int getCourceCode() {
        return courceCode;
    }

    public void setCourceCode(int courceCode) {
        this.courceCode = courceCode;
    }

    public int getCourceId() {
        return courceId;
    }

    public void setCourceId(int courceId) {
        this.courceId = courceId;
    }

    public int courceYear;
}
