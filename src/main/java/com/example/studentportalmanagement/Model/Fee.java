package com.example.studentportalmanagement.Model;

import com.example.studentportalmanagement.Repository.Do.StudentDO;

import java.util.List;

public class Fee {

    public int feeId;
    public double monthFee;
    public double paidFee;
    public double remainingFee;
    public String feePaidDate;
    public String feeStatus;
    public String monthName;
    public String addOns;
    public double addOnsFee;
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

    public int getFeeId() {return feeId;}

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

    public StudentDO getStudentDO() {
        return studentDO;
    }

    public void setStudentDO(StudentDO studentDO) {
        this.studentDO = studentDO;
    }
}
