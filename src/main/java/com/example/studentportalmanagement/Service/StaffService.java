package com.example.studentportalmanagement.Service;

import com.example.studentportalmanagement.Model.*;
import com.example.studentportalmanagement.Repository.DAO.LoginDetailsRepository;
import com.example.studentportalmanagement.Repository.DAO.SalaryRepository;
import com.example.studentportalmanagement.Repository.DAO.StaffRepository;
import com.example.studentportalmanagement.Repository.Do.LoginDetailsDO;
import com.example.studentportalmanagement.Repository.Do.SalaryDO;
import com.example.studentportalmanagement.Repository.Do.StaffDO;
import com.example.studentportalmanagement.Repository.Do.TeachingScheduleDO;
import com.example.studentportalmanagement.Repository.DAO.TeachingScheduleRepository;
import com.example.studentportalmanagement.Service.Mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private LoginDetailsRepository loginDetailsRepository;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private SalaryRepository salaryRepository;
    @Autowired
    TeachingScheduleRepository teachingScheduleRepository;

    public Staff getStaffById(int id) {
        Optional<StaffDO> staffDO = staffRepository.findById(id);
        if (staffDO.isPresent()){
            StaffDO staffDO1 = staffDO.get();
            Staff staff = new Staff();
            staff.setStaffId(staffDO1.getStaffId());
            staff.setStaffName(staffDO1.getStaffName());
            staff.setAddress(staffDO1.getAddress());
            staff.setEmail(staffDO1.getEmail());
            staff.setGender(staffDO1.getGender());
            staff.setContactNumber(staffDO1.getContactNumber());
            staff.setDateOfBirth(staffDO1.getDateOfBirth());
            staff.setStaffRole(staffDO1.getStaffRole());
            staff.setStaffStatus(staffDO1.getStaffStatus());
            return staff;
        }
        return null;
    }


    public LoginDetails loginStaff(LoginDetails loginDetails) {
        String useName = loginDetails.getUserName();
        LoginDetailsDO loginDetailsDO = loginDetailsRepository.getLoginDetailsDOByUserName(useName);
        if (null!=loginDetailsDO && Objects.equals(loginDetails.getStdPassword(),loginDetailsDO.getStdPassword())){
            return staffMapper.mapToLoginDetails(loginDetailsDO);
        }else {
            return loginDetails;
        }
    }

    public Staff staffProfile(String userName){
       LoginDetailsDO loginDetailsDO = loginDetailsRepository.getLoginDetailsDOByUserName(userName);
       int staffId = loginDetailsDO.getStaffId();
       StaffDO staffDO = staffRepository.getStaffDOByStaffId(staffId);
       return staffMapper.mapToStaffDO(staffDO);
    }

    public Salary staffSalary(String userName){
        LoginDetailsDO loginDetailsDO = loginDetailsRepository.getLoginDetailsDOByUserName(userName);
        int salaryId = loginDetailsDO.getStaffId();
        SalaryDO salaryDO = salaryRepository.getSalaryDOBySalaryId(salaryId);
        if (null == salaryDO){
            return null;
        }
        return staffMapper.mapToSalaryDO(salaryDO);
    }

    public List<Salary> getstaffSalary(int staffId){
        StaffDO staffDO = staffRepository.getStaffDOByStaffId(staffId);
        int staffId1 = staffDO.getStaffId();
        List<SalaryDO> salaryDOList = salaryRepository.getSalaryDOByStaffDO(staffDO);
        if(salaryDOList == null){
            return  null;
        }
        return staffMapper.mapToSalary(salaryDOList);
    }

    public TeachingSchedule teachingSchedule(String uerName){
        LoginDetailsDO loginDetailsDO = loginDetailsRepository.getLoginDetailsDOByUserName(uerName);
        int teachingScheduleId = loginDetailsDO.getStaffId();
        TeachingScheduleDO teachingScheduleDO = teachingScheduleRepository.getTeachingScheduleByTeachingScheduleId(teachingScheduleId);
        if (null == teachingScheduleDO){
            return null;
        }
        return staffMapper.mapToTeachingScheduleDO(teachingScheduleDO);
    }

    public List<Staff> getStaffList() {
        List<StaffDO> staffDOList = staffRepository.findAll();
        List<Staff> staffList = new ArrayList<>();
        for (StaffDO staffDO : staffDOList){
            staffList.add(staffMapper.mapToStaffDO(staffDO));
        }
        return staffList;
    }

//    public Staff getStaffByStaffId(int staffId){
//        StaffDO staffDO = staffRepository.getStaffDOByStaffId(staffId);
//        if (staffDO != null){
//            return staffMapper.mapToStaff(staffDO);
//        }else {
//            return null;
//        }
//    }

    public Staff UpdateStaff(Staff staff){
        Optional<StaffDO> staffDO = staffRepository.findById(staff.getStaffId());
        StaffDO staffDO1Result =staffDO.get();
        staffDO1Result.setStaffName(staff.getStaffName());
        staffDO1Result.setStaffStatus(staff.getStaffStatus());
        staffDO1Result.setStaffRole(staff.getStaffRole());
        staffDO1Result.setAddress(staff.getAddress());
        staffDO1Result.setContactNumber(staff.getContactNumber());
        staffDO1Result.setDateOfBirth(staff.getDateOfBirth());
        staffDO1Result.setEmail(staff.getEmail());
        staffDO1Result.setGender(staff.getGender());
        StaffDO staffDO1 = staffRepository.save(staffDO1Result);
        return staffMapper.mapToStaff(staffDO1);
    }

    public Salary saveSalary(int staffId,Salary salary) {
        SalaryDO salaryDO = new SalaryDO();
        StaffDO staffDO = new StaffDO();
        staffDO.setStaffId(staffId);
        salaryDO.setStaffDO(staffDO);
        salaryDO.setMonthName(salary.getMonthName());
        salaryDO.setMonthSalary(salary.getMonthSalary());
        salaryDO.setPaidSalary(salary.getPaidSalary());
        salaryDO.setRemainingSalary(salary.getRemainingSalary());
        salaryDO.setSalaryStatus(salary.getSalaryStatus());
        salaryDO.setSalaryPaidDate(salary.getSalaryPaidDate());
        salaryDO.setDescriptionBox(salary.getDescriptionBox());
        SalaryDO result = salaryRepository.save(salaryDO);

        return staffMapper.mapToSalaryDO(result);
    }

    public Salary updateStaffSalary(int staffId,Salary salary) {
        Optional<SalaryDO> salaryDO = salaryRepository.findById(salary.getSalaryId());
        SalaryDO salaryDO1 = salaryDO.get();
        StaffDO staffDO = new StaffDO();
        staffDO.setStaffId(staffId);
        salaryDO1.setStaffDO(staffDO);
        salaryDO1.setMonthName(salary.getMonthName());
        salaryDO1.setMonthSalary(salary.getMonthSalary());
        salaryDO1.setPaidSalary(salary.getPaidSalary());
        salaryDO1.setRemainingSalary(salary.getRemainingSalary());
        salaryDO1.setSalaryPaidDate(salary.getSalaryPaidDate());
        salaryDO1.setSalaryStatus(salary.getSalaryStatus());
        salaryDO1.setDescriptionBox(salary.getDescriptionBox());
        SalaryDO salaryDO1result = salaryRepository.save(salaryDO1);

        return staffMapper.mapToSalary(salaryDO1result);
    }

//    public Salary getSalaryById(int id) {
//        Optional<SalaryDO> salaryDO = salaryRepository.findById(id);
//        if (salaryDO.isPresent()){
//            SalaryDO salaryDO1 = salaryDO.get();
//            Salary salary = new Salary();
//            salary.setSalaryId(salaryDO1.getSalaryId());
//            salary.setMonthName(salaryDO1.getMonthName());
//            salary.setMonthSalary(salaryDO1.getMonthSalary());
//            salary.setPaidSalary(salaryDO1.getPaidSalary());
//            salary.setRemainingSalary(salaryDO1.getRemainingSalary());
//            salary.setSalaryPaidDate(salaryDO1.getSalaryPaidDate());
//            salary.setSalaryStatus(salaryDO1.getSalaryStatus());
//            salary.setDescriptionBox(salaryDO1.getDescriptionBox());
//            return salary;
//        }
//        return null;
//    }

//    public Salary getstaffSalary1(int staffId){
//        StaffDO staffDO = staffRepository.getStaffDOByStaffId(staffId);
//        int staffId1 = staffDO.getStaffId();
//        SalaryDO salaryDO = salaryRepository.getSalaryDOBySalaryId(staffId);
//        if(salaryDO == null){
//            return  null;
//        }
//        return staffMapper.mapToSalary(salaryDO);
//    }

    public Salary getSalaryById(int salaryId) {
        SalaryDO salaryDO = salaryRepository.getSalaryDOBySalaryId(salaryId);
        if (salaryDO == null){
            return null;
        }else {
            return staffMapper.mapToSalary(salaryDO);
        }
    }

    public Salary getSalaryByIdAndMonthName(int salaryId, String monthName) {
        SalaryDO salaryDO = salaryRepository.getSalaryDOBySalaryIdAndMonthName(salaryId,monthName);
        if (salaryDO == null){
            return null;
        }else {
            return staffMapper.mapToSalary(salaryDO);
        }
    }

    public Salary getSalaryByMonthNameAndStaffId(String monthName,int staffId) {
        StaffDO staffDO= new StaffDO();
        staffDO.setStaffId(staffId);
        SalaryDO salaryDO = salaryRepository.getSalaryDOByMonthNameAndStaffDO(monthName,staffDO);
        if (salaryDO == null){
            return null;
        }else {
            return staffMapper.mapToSalary(salaryDO);
        }
    }

    public List<Salary> getSalaryBySalaryStatusAndStaffId(String salaryStatus,int staffId) {
        StaffDO staffDO = new StaffDO();
        staffDO.setStaffId(staffId);
        List<SalaryDO> salaryDOList = salaryRepository.getSalaryDOBySalaryStatusAndStaffDO(salaryStatus,staffDO);
        if (salaryStatus == null){
            return null;
        }else {
            return staffMapper.mapToSalary(salaryDOList);
        }
    }

//    public List<Salary> get(int salaryId) {
//        SalaryDO salaryDO = salaryRepository.getSalaryDOBySalaryId(salaryId);
//        if (salaryDO != null){
//            return  staffMapper.mapToSalary(salaryDO);
//        }
//        return null;
//    }
}
