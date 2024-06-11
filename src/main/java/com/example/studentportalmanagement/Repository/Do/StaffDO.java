package com.example.studentportalmanagement.Repository.Do;

import com.example.studentportalmanagement.Model.Staff;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "staff")
public class StaffDO {

    @Id
    @Column(name = "staff_id")
    public int staffId;

    @Column(name = "staff_name")
    public String staffName;

    @Column(name = "address")
    public String address;

    @Column(name = "email")
    public String email;

    @Column(name = "contact_number")
    public long contactNumber;

    @Column(name = "date_of_birth")
    public String dateOfBirth;

    @Column(name = "gender")
    public String gender;

    @Column(name = "staff_status")
    public String staffStatus;

    @Column(name = "staff_role")
    public String staffRole;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "staffDO", cascade = CascadeType.ALL)
    public List<SalaryDO> salaryDOList;

    public List<SalaryDO> getSalaryDOList() {
        return salaryDOList;
    }

    public void setSalaryDOList(List<SalaryDO> salaryDOList) {
        this.salaryDOList = salaryDOList;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

    public String getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }

}
