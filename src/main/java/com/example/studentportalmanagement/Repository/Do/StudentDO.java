package com.example.studentportalmanagement.Repository.Do;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "student")
public class StudentDO {

    @Id
    @Column(name = "student_id")
    public int studentId;
    @Column(name = "student_name")
    public String studentName;
    @Column(name = "father_name")
    public String fatherName;
    @Column(name = "mother_name")
    public String motherName;
    @Column(name = "date_of_birth")
    public String dateOfBirth;
    @Column(name = "email")
    public String email;
    @Column(name = "gender")
    public String gender;
    @Column(name = "contact_number")
    public long contactNumber;
    @Column(name = "category")
    public String category;
    @Column(name = "father_occupation")
    public String fatherOccupation;
    @Column(name = "staff_role")
    public String staffRole;


//    @Column(name = "user_name")
//    public String userName;
//    @Column(name = "std_password")
//    public  String stdPassword;

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }

//    public  String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public  String getStdPassword() {
//        return stdPassword;
//    }
//
//    public void setStdPassword(String stdPassword) {
//        this.stdPassword = stdPassword;
//    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studentDO", cascade = CascadeType.ALL)
    public List<FeeDO> feeDOList;

    public List<FeeDO> getFeeDOList() {
        return feeDOList;
    }

    public void setFeeDOList(List<FeeDO> feeDOList) {
        this.feeDOList = feeDOList;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFatherOccupation() {
        return fatherOccupation;
    }

    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
    }
}
