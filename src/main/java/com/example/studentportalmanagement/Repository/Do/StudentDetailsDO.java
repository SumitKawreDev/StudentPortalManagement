package com.example.studentportalmanagement.Repository.Do;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "student_details")
public class StudentDetailsDO {

    @Id
    @Column(name = "student_certificate")
    public String studentCertificate;
    @Column(name = "board_name")
    public String boardName;
    @Column(name = "school_name")
    public String schoolName;
    @Column(name = "percentage_10th")
    public double percentage10th;
    @Column(name = "percentage_12th")
    public double percentage12th;
    @Column(name = "location")
    public String location;

    public String getStudentCertificate() {
        return studentCertificate;
    }

    public void setStudentCertificate(String studentCertificate) {
        this.studentCertificate = studentCertificate;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public double getPercentage10th() {
        return percentage10th;
    }

    public void setPercentage10th(double percentage10th) {
        this.percentage10th = percentage10th;
    }

    public double getPercentage12th() {
        return percentage12th;
    }

    public void setPercentage12th(double percentage12th) {
        this.percentage12th = percentage12th;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
