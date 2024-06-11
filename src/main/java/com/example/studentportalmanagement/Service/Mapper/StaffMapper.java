package com.example.studentportalmanagement.Service.Mapper;

import com.example.studentportalmanagement.Model.*;
import com.example.studentportalmanagement.Repository.Do.LoginDetailsDO;
import com.example.studentportalmanagement.Repository.Do.SalaryDO;
import com.example.studentportalmanagement.Repository.Do.StaffDO;
import com.example.studentportalmanagement.Repository.Do.TeachingScheduleDO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StaffMapper {

    public Salary mapToSalary(SalaryDO salaryDO){
        Salary salary = new Salary();
        salary.setSalaryId(salaryDO.getSalaryId());
        salary.setMonthName(salaryDO.getMonthName());
        salary.setMonthSalary(salaryDO.getMonthSalary());
        salary.setPaidSalary(salaryDO.getPaidSalary());
        salary.setRemainingSalary(salaryDO.getRemainingSalary());
        salary.setSalaryPaidDate(salaryDO.getSalaryPaidDate());
        salary.setSalaryStatus(salaryDO.getSalaryStatus());
        salary.setDescriptionBox(salaryDO.getDescriptionBox());
        return salary;
    }





    public Salary mapToSalaryDO(SalaryDO salaryDO){
        Salary salary = new Salary();
        salary.setSalaryId(salaryDO.getSalaryId());
        salary.setMonthName(salaryDO.getMonthName());
        salary.setPaidSalary(salaryDO.getPaidSalary());
        salary.setRemainingSalary(salaryDO.getRemainingSalary());
        salary.setMonthSalary(salaryDO.getMonthSalary());
        salary.setSalaryPaidDate(salaryDO.getSalaryPaidDate());
        salary.setSalaryStatus(salaryDO.getSalaryStatus());
        salary.setDescriptionBox(salaryDO.getDescriptionBox());
        return salary;
    }

    public Staff mapToStaffDO(StaffDO staffDO){
        Staff staff = new Staff();
        staff.setStaffId(staffDO.getStaffId());
        staff.setStaffName(staffDO.getStaffName());
        staff.setContactNumber(staffDO.getContactNumber());
        staff.setDateOfBirth(staffDO.getDateOfBirth());
        staff.setGender(staffDO.getGender());
        staff.setStaffStatus(staffDO.getStaffStatus());
        staff.setEmail(staffDO.getEmail());
        staff.setAddress(staffDO.getAddress());
        staff.setStaffRole(staffDO.getStaffRole());
        return staff;
    }
    public TeachingSchedule mapToTeachingScheduleDO(TeachingScheduleDO teachingScheduleDO){
        TeachingSchedule teachingSchedule = new TeachingSchedule();
        teachingSchedule.setTeachingScheduleId(teachingScheduleDO.getTeachingScheduleId());
        teachingSchedule.setEngage(teachingScheduleDO.getEngage());
        teachingSchedule.setClassName(teachingScheduleDO.getClassName());
        teachingSchedule.setSub(teachingScheduleDO.getSub());
        teachingSchedule.setTiming(teachingScheduleDO.getTiming());
        teachingSchedule.setTimeDuration(teachingScheduleDO.getTimeDuration());
        return teachingSchedule;
    }

    public LoginDetails mapToLoginDetails(LoginDetailsDO loginDetailsDO){
        LoginDetails loginDetails = new LoginDetails();
        loginDetails.setStudentId(loginDetailsDO.getStudentId());
        loginDetails.setStaffRole(loginDetailsDO.getStaffRole());
        loginDetails.setUserName(loginDetailsDO.getUserName());
        return loginDetails;
    }

    public List<Salary> mapToSalary(List<SalaryDO> salaryDOList) {
        List<Salary> salaryList = new ArrayList<>();
        for (SalaryDO salaryDO: salaryDOList){
            Salary salary = new Salary();
            salary.setSalaryId(salaryDO.getSalaryId());
            salary.setMonthName(salaryDO.getMonthName());
            salary.setMonthSalary(salaryDO.getMonthSalary());
            salary.setPaidSalary(salaryDO.getPaidSalary());
            salary.setRemainingSalary(salaryDO.getRemainingSalary());
            salary.setSalaryPaidDate(salaryDO.getSalaryPaidDate());
            salary.setSalaryStatus(salaryDO.getSalaryStatus());
            salary.setDescriptionBox(salaryDO.getDescriptionBox());
            salaryList.add(salary);
        }
        return salaryList;
    }

    public Staff mapToStaff(StaffDO staffDO) {
        Staff staff = new Staff();
        staff.setStaffId(staffDO.getStaffId());
        staff.setStaffName(staffDO.getStaffName());
        staff.setAddress(staffDO.getAddress());
        staff.setStaffStatus(staffDO.getStaffStatus());
        staff.setStaffRole(staffDO.getStaffRole());
        staff.setEmail(staffDO.getEmail());
        staff.setGender(staffDO.getGender());
        staff.setContactNumber(staffDO.getContactNumber());
        staff.setDateOfBirth(staffDO.getDateOfBirth());
        return staff;
    }
}
