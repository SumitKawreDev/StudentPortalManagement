package com.example.studentportalmanagement.Service.Mapper;

import com.example.studentportalmanagement.Model.Fee;
import com.example.studentportalmanagement.Model.Student;
import com.example.studentportalmanagement.Repository.DAO.StudentRepository;
import com.example.studentportalmanagement.Repository.Do.FeeDO;
import com.example.studentportalmanagement.Repository.Do.StudentDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {

    @Autowired
    private StudentRepository studentRepository;

    public List<Fee> mapToFee(List<FeeDO> feeDOList){
        List<Fee> feeList = new ArrayList<>();
        for (FeeDO feeDO:feeDOList){
            Fee fee = new Fee();
            fee.setFeeId(feeDO.getFeeId());
            fee.setFeeStatus(feeDO.getFeeStatus());
            fee.setPaidFee(feeDO.getPaidFee());
            fee.setRemainingFee(feeDO.getRemainingFee());
            fee.setFeePaidDate(feeDO.getFeePaidDate());
            fee.setMonthFee(feeDO.getMonthFee());
            fee.setMonthName(feeDO.getMonthName());
            fee.setAddOns(feeDO.getAddOns());
            fee.setAddOnsFee(feeDO.getAddOnsFee());
            feeList.add(fee);
        }
        return feeList;
    }
    public List<FeeDO> mapToFeeDO(List<Fee> feeList, StudentDO studentDO){
        List<FeeDO> feeDOList = new ArrayList<>();
        for (Fee fee: feeList){
            FeeDO feeDO = new FeeDO();
            feeDO.setFeeId(fee.getFeeId());
            feeDO.setMonthFee(fee.getMonthFee());
            feeDO.setFeeStatus(fee.getFeeStatus());
            feeDO.setPaidFee(fee.getPaidFee());
            feeDO.setRemainingFee(fee.getRemainingFee());
            feeDO.setFeePaidDate(fee.getFeePaidDate());
            feeDO.setAddOns(fee.getAddOns());
            feeDO.setAddOnsFee(fee.getAddOnsFee());
            feeDO.setMonthName(fee.getMonthName());
            feeDO.setStudentDO(studentDO);
            feeDOList.add(feeDO);
        }
        return feeDOList;
    }


    public Student mapStudentDO(StudentDO studentDO){
        Student student = new Student();
        student.setStudentId(studentDO.getStudentId());
//        student.setUserName(studentDO.getUserName());
//        student.setstdPassword(studentDO.getStdPassword());
        student.setStudentName(studentDO.getStudentName());
        student.setFatherName(studentDO.getFatherName());
        student.setCategory(studentDO.getCategory());
        student.setGender(studentDO.getGender());
        student.setEmail(studentDO.getEmail());
        student.setContactNumber(studentDO.getContactNumber());
        student.setDateOfBirth(studentDO.getDateOfBirth());
        student.setMotherName(studentDO.getMotherName());
        student.setFatherOccupation(studentDO.getFatherOccupation());
        student.setStaffRole(studentDO.getStaffRole());
        return student;
    }
    public Fee mapToFeeDO(FeeDO feeDO) {
        Fee fee = new Fee();
        fee.setFeeId(feeDO.getFeeId());
        fee.setMonthFee(feeDO.getMonthFee());
        fee.setPaidFee(feeDO.getPaidFee());
        fee.setRemainingFee(feeDO.getRemainingFee());
        fee.setFeePaidDate(feeDO.getFeePaidDate());
        fee.setFeeStatus(feeDO.getFeeStatus());
        fee.setMonthName(feeDO.getMonthName());
        fee.setAddOns(feeDO.getAddOns());
        fee.setAddOnsFee(feeDO.getAddOnsFee());
        return fee;
    }

    public List<Student> getStudentList(){
        List<StudentDO> studentDoList = studentRepository.findAll();
        List<Student> studentList = new ArrayList<>();
        for (StudentDO studentDO:studentDoList){
            Student student = new Student();
            student.setStudentId(studentDO.getStudentId());
            student.setStudentName(studentDO.getStudentName());
            student.setStaffRole(studentDO.getStaffRole());
            student.setEmail(studentDO.getEmail());
            student.setGender(studentDO.getGender());
            student.setFatherOccupation(studentDO.getFatherOccupation());
            student.setMotherName(studentDO.getMotherName());
            student.setDateOfBirth(studentDO.getDateOfBirth());
            student.setContactNumber(studentDO.getContactNumber());
            student.setCategory(studentDO.getCategory());
            studentList.add(student);
        }
        return studentList;
    }

}
