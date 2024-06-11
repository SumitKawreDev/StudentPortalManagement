package com.example.studentportalmanagement.Repository.Do;

import jakarta.persistence.*;

@Entity (name = "fee" )
public class FeeDO {

    @Id
    @Column(name = "fee_id")
    public int feeId;
    @Column(name = "month_fee")
    public double monthFee;
    @Column(name = "paid_fee")
    public double paidFee;
    @Column(name = "remaining_fee")
    public double remainingFee;
    @Column(name = "fee_paid_date")
    public String feePaidDate;
    @Column(name = "fee_status")
    public String feeStatus;
    @Column(name = "month_name")
    public String monthName;
    @Column(name = "add_ons")
    public String addOns;
    @Column(name = "add_ons_fee")
    public double addOnsFee;

    @ManyToOne
    @JoinColumn(name="student_id")
    private StudentDO studentDO;

    public double getMonthFee() {
        return monthFee;
    }

    public void setMonthFee(double monthFee) {
        this.monthFee = monthFee;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getAddOns() {
        return addOns;
    }

    public void setAddOns(String addOns) {
        this.addOns = addOns;
    }

    public double getAddOnsFee() {
        return addOnsFee;
    }

    public void setAddOnsFee(double addOnsFee) {
        this.addOnsFee = addOnsFee;
    }

    public StudentDO getStudentDO() {
        return studentDO;
    }

    public void setStudentDO(StudentDO studentDO) {
        this.studentDO = studentDO;
    }

    public int getFeeId() {
        return feeId;
    }

    public void setFeeId(int feeId) {
        this.feeId = feeId;
    }

    public double getPaidFee() {
        return paidFee;
    }

    public void setPaidFee(double paidFee) {
        this.paidFee = paidFee;
    }

    public double getRemainingFee() {
        return remainingFee;
    }

    public void setRemainingFee(double remainingFee) {
        this.remainingFee = remainingFee;
    }

    public String getFeePaidDate() {
        return feePaidDate;
    }

    public void setFeePaidDate(String feePaidDate) {
        this.feePaidDate = feePaidDate;
    }

    public String getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(String feeStatus) {
        this.feeStatus = feeStatus;
    }

}
