package com.example.studentportalmanagement.Repository.Do;

import jakarta.persistence.*;

@Entity(name = "salary")
public class SalaryDO {

    @Id
    @Column(name = "salary_id")
    public int salaryId;

    @Column(name = "month_name")
    public String monthName;

    @Column(name = "month_salary")
    public double monthSalary;

    @Column(name = "paid_salary")
    public double paidSalary;

    @Column(name = "remaining_salary")
    public double remainingSalary;

    @Column(name = "salary_paid_date")
    public String salaryPaidDate;

    @Column(name = "salary_status")
    public String salaryStatus;

    @Column(name = "description_box")
    public String descriptionBox;

    @ManyToOne
    @JoinColumn(name="staff_id")
    private StaffDO staffDO;

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

    public double getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(double monthSalary) {
        this.monthSalary = monthSalary;
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
