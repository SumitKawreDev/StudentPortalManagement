package com.example.studentportalmanagement.Repository.Do;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "attendance")
public class AttendanceDO {

    @Id
    @Column(name = "attendance_id")
    public int attendanceId;
    @Column(name = "present")
    public int present;
    @Column(name = "absent")
    public int absent;
    @Column(name = "total_attendance")
    public int totalAttendance;
    @Column(name = "month_name")
    public String monthName;
    @Column(name = "year_name")
    public String yearName;
    @Column(name = "leave_type")
    public String leaveType;

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }

    public int getTotalAttendance() {
        return totalAttendance;
    }

    public void setTotalAttendance(int totalAttendance) {
        this.totalAttendance = totalAttendance;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getYearName() {
        return yearName;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }
}
