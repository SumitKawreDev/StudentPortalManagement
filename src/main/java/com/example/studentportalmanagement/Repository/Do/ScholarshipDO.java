package com.example.studentportalmanagement.Repository.Do;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "scholarship")
public class ScholarshipDO {

    @Id
    @Column(name = "scholarship_id")
    public int scholarshipId;
    @Column(name = "scholarship_type")
    public String scholarshipType;
    @Column(name = "scholarship_details")
    public String scholarshipDetails;
    @Column(name = "scholarship_eligibility")
    public String scholarshipEligibility;

    public int getScholarshipId() {
        return scholarshipId;
    }

    public void setScholarshipId(int scholarshipId) {
        this.scholarshipId = scholarshipId;
    }

    public String getScholarshipType() {
        return scholarshipType;
    }

    public void setScholarshipType(String scholarshipType) {
        this.scholarshipType = scholarshipType;
    }

    public String getScholarshipDetails() {
        return scholarshipDetails;
    }

    public void setScholarshipDetails(String scholarshipDetails) {
        this.scholarshipDetails = scholarshipDetails;
    }

    public String getScholarshipEligibility() {
        return scholarshipEligibility;
    }

    public void setScholarshipEligibility(String scholarshipEligibility) {
        this.scholarshipEligibility = scholarshipEligibility;
    }
}
