package com.example.studentportalmanagement.Model;

import com.example.studentportalmanagement.Repository.Do.StaffDO;

public class Salary {

    public int salaryId;

    public String monthName;

    public double monthSalary;

    public double paidSalary;

    public double remainingSalary;

    public String salaryPaidDate;

    public String salaryStatus;

    public String descriptionBox;

    private StaffDO staffDO;

    public double getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(double monthSalary) {
        this.monthSalary = monthSalary;
    }


    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getDescriptionBox() {
        return descriptionBox;
    }

    public void setDescriptionBox(String descriptionBox) {
        this.descriptionBox = descriptionBox;
    }

    public StaffDO getStaffDO() {
        return staffDO;
    }

    public void setStaffDO(StaffDO staffDO) {
        this.staffDO = staffDO;
    }


    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    public double getPaidSalary() {
        return paidSalary;
    }

    public void setPaidSalary(double paidSalary) {
        this.paidSalary = paidSalary;
    }

    public double getRemainingSalary() {
        return remainingSalary;
    }

    public void setRemainingSalary(double remainingSalary) {
        this.remainingSalary = remainingSalary;
    }

    public String getSalaryPaidDate() {
        return salaryPaidDate;
    }

    public void setSalaryPaidDate(String salaryPaidDate) {
        this.salaryPaidDate = salaryPaidDate;
    }

    public String getSalaryStatus() {
        return salaryStatus;
    }

    public void setSalaryStatus(String salaryStatus) {
        this.salaryStatus = salaryStatus;
    }
}
