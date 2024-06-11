package com.example.studentportalmanagement.Model;

public class Scholarship {

    public int scholarshipId;
    public String scholarshipType;
    public String scholarshipDetails;
    public String scholarshipEligibility;

    public String getScholarshipEligibility() {
        return scholarshipEligibility;
    }

    public void setScholarshipEligibility(String scholarshipEligibility) {
        this.scholarshipEligibility = scholarshipEligibility;
    }

    public String getScholarshipDetails() {
        return scholarshipDetails;
    }

    public void setScholarshipDetails(String scholarshipDetails) {
        this.scholarshipDetails = scholarshipDetails;
    }

    public String getScholarshipType() {
        return scholarshipType;
    }

    public void setScholarshipType(String scholarshipType) {
        this.scholarshipType = scholarshipType;
    }

    public int getScholarshipId() {
        return scholarshipId;
    }

    public void setScholarshipId(int scholarshipId) {
        this.scholarshipId = scholarshipId;
    }

}
