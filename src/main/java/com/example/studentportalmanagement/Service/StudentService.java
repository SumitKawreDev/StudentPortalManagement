package com.example.studentportalmanagement.Service;

import com.example.studentportalmanagement.Model.Fee;
import com.example.studentportalmanagement.Model.LoginDetails;
import com.example.studentportalmanagement.Model.Staff;
import com.example.studentportalmanagement.Model.Student;
import com.example.studentportalmanagement.Repository.DAO.FeeRepository;
import com.example.studentportalmanagement.Repository.DAO.LoginDetailsRepository;
import com.example.studentportalmanagement.Repository.DAO.StudentRepository;
import com.example.studentportalmanagement.Repository.Do.FeeDO;
import com.example.studentportalmanagement.Repository.Do.LoginDetailsDO;
import com.example.studentportalmanagement.Repository.Do.StaffDO;
import com.example.studentportalmanagement.Repository.Do.StudentDO;
import com.example.studentportalmanagement.Service.Mapper.StaffMapper;
import com.example.studentportalmanagement.Service.Mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository  studentRepository;
    @Autowired
    private LoginDetailsRepository loginDetailsRepository;
    @Autowired
    private FeeRepository feeRepository;
    @Autowired
    public StudentMapper studentMapper;


    public Student getStudentById(int id){
        Optional<StudentDO> studentDO = studentRepository.findById(id);
        if(studentDO.isPresent()){
            StudentDO studentDO1 = studentDO.get();
            Student student = new Student();
            student.setStudentId(studentDO1.getStudentId());
            student.setStudentName(studentDO1.getStudentName());
            student.setCategory(studentDO1.getCategory());
            student.setEmail(studentDO1.getEmail());
            student.setGender(studentDO1.getGender());
            student.setContactNumber(studentDO1.getContactNumber());
            student.setDateOfBirth(studentDO1.getDateOfBirth());
            student.setFatherName(studentDO1.getFatherName());
            student.setFatherOccupation(studentDO1.getFatherOccupation());
            student.setMotherName(studentDO1.getMotherName());
            student.setStaffRole(studentDO1.getStaffRole());
//            student.setUserName(studentDO1.getUserName());
//            student.setstdPassword(studentDO1.getStdPassword());
            student.setFeeList(studentMapper.mapToFee(studentDO1.getFeeDOList()));
            return student;
        }
        return null;
    }
    public String saveStudent(Student student){
        StudentDO studentDO = new StudentDO();
        studentDO.setStudentId(student.getStudentId());
        studentDO.setStudentName(student.getStudentName());
        studentDO.setFatherName(student.getFatherName());
        studentDO.setFatherOccupation(student.getFatherOccupation());
        studentDO.setMotherName(student.getMotherName());
        studentDO.setCategory(student.getCategory());
        studentDO.setGender(student.getGender());
        studentDO.setEmail(student.getEmail());
        studentDO.setContactNumber(student.getContactNumber());
        studentDO.setDateOfBirth(student.getDateOfBirth());
//        studentDO.setUserName(student.getUserName());
//        studentDO.setStdPassword(student.getstdPassword());
//        studentDO.setFeeDOList(studentMapper.mapToFeeDO(student.getFeeList(),studentDO));

        // It save student
        studentRepository.save(studentDO);

        return "saved succcessfully";
    }

    public List<Student> getstudent() {
        return null;
    }

//    public List<StudentDO> listAll(String keyword) {
//        if (keyword != null) {
//            return studentRepository.search(keyword);
//        }
//        return null;
//    }

//    public LoginDetails loginStudent(LoginDetails loginDetails) {
//
//        String userName = LoginDetails.getUserName();
//        LoginDetailsDO loginDetailsDO = loginDetailsRepository.getLoginDetailsByUserName(userName);
//        if(Objects.equals(loginDetailsDO.getStdPassword(), loginDetails.getStdPassword())) {
//            return studentMapper.mapStudentDO(loginDetailsDO);
//        }else {
//            return null;
//        }
//    }

//    public Student loginStudent(Student student) {
//        String userName = student.getUserName();
//        StudentDO studentDO = studentRepository.getStudentByUserName(userName);
//        if(null!= studentDO && Objects.equals(student.getstdPassword(), studentDO.getStdPassword())) {
//           return studentMapper.mapStudentDO(studentDO);
//        }else {
//            return null;
//        }
//    }

//    public Boolean loginStudent(Student student){
//        String userName = student.getUserName();
//        StudentDO studentDO = studentRepository.getStudentByUserName(userName);
//        if( null != studentDO && Objects.equals(student.getstdPassword(), studentDO.getStdPassword())) {
//            return true;
//        }else {
//            return false;
//        }
//    }

    public Student loginStudent(LoginDetails loginDetails) {
        String userName = loginDetails.getUserName();
        LoginDetailsDO loginDetailsDO = loginDetailsRepository.getLoginDetailsDOByUserName(userName);
        if (null!=loginDetailsDO && Objects.equals(loginDetails.getStdPassword(),loginDetailsDO.getStdPassword())){
            StudentDO studentDO = studentRepository.getStudentDOByStudentId(loginDetailsDO.getStudentId());
            if(null!=studentDO) {
                return studentMapper.mapStudentDO(studentDO);
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    public Student studentProfile(int studentId){
            StudentDO studentDO = studentRepository.getStudentDOByStudentId(studentId);
            if (null==studentDO){
                return null;
            }
            return studentMapper.mapStudentDO(studentDO);
    }
//    public Student studentHome(String userName){
//        StudentDO studentDO = studentRepository.getStudentByUserName(userName);
//        return studentMapper.mapStudentDO(studentDO);
//    }
    public List<Fee> studentFee(int studentId){
        StudentDO studentDO = studentRepository.getStudentDOByStudentId(studentId);
        int studendId = studentDO.getStudentId();
        List<FeeDO> feeDOList = feeRepository.getFeeDOByStudentDO(studentDO);
        if(null == feeDOList){
            return null;
        }
        return studentMapper.mapToFee(feeDOList);
    }


    public List<Student> getStudentList() {
        List<StudentDO> studentDOList = studentRepository.findAll();
        List<Student> studentList = new ArrayList<>();
        for (StudentDO studentDO : studentDOList) {
            studentList.add(studentMapper.mapStudentDO(studentDO));
        }
        return studentList;
    }

//    public List<Fee> getFeeList() {
//        List<StudentDO> studentDOList = studentRepository.findAll();
//        List<Fee> feeList = new ArrayList<>();
//        for (StudentDO studentDO : studentDOList) {
//            FeeDO feeDO = feeRepository.getFeeDOByStudentDO(studentDO);
//            feeList.add(studentMapper.mapToFeeDO(feeDO));
//        }
//        return feeList;
//    }

    public List<Fee> getFeeList() {
        List<StudentDO> studentDOList = studentRepository.findAll();
        List<Fee> feeList = new ArrayList<>();
        for(StudentDO studentDO: studentDOList){
            FeeDO feeDO = (FeeDO) feeRepository.getFeeDOByStudentDO(studentDO);
            feeList.add(studentMapper.mapToFeeDO(feeDO));
        }
        return feeList;
    }
    public List<Fee> getFeeListbyStudentId(int studentId) {
            StudentDO studentDO = new StudentDO();
            studentDO.setStudentId(studentId);
            List<FeeDO> feeDOList = feeRepository.getFeeDOByStudentDO(studentDO);
            if(null==feeDOList){
                return null;
            }else {
                return studentMapper.mapToFee(feeDOList);
            }
    }

    /**
     * saveFee method for Save Fee Details
     * @param fee
     * @param studentId
     * @return feeDO
     */
    public Fee saveFee(Fee fee,int studentId){
        FeeDO feeDO = new FeeDO();
        StudentDO studentDO =new StudentDO();
        studentDO.setStudentId(studentId);
        feeDO.setStudentDO(studentDO);
        feeDO.setMonthFee(fee.getMonthFee());
        feeDO.setFeeStatus(fee.getFeeStatus());
        feeDO.setPaidFee(fee.getPaidFee());
        feeDO.setRemainingFee(fee.getRemainingFee());
        feeDO.setAddOnsFee(fee.getAddOnsFee());
        feeDO.setAddOns(fee.getAddOns());
        feeDO.setMonthName(fee.getMonthName());
        feeDO.setFeePaidDate(fee.getFeePaidDate());
        FeeDO result = feeRepository.save(feeDO);

        return studentMapper.mapToFeeDO(result);
    }

    public void deleteFee(int feeId) {
        feeRepository.deleteById(feeId);

    }

//    public List<FeeDO> listAll(String keyword){
//        if (keyword != null){
//            return feeRepository.search(keyword);
//        }
//        return null;
//    }

    public List<Fee> getFeeListByMonthName(String monthName) {
        List<FeeDO> feeDOList = feeRepository.getFeeDOByMonthName(monthName);
        if(feeDOList != null) {
            return studentMapper.mapToFee(feeDOList);
        }else {
            return null;
        }
    }

    public List<Fee> getFeeListByFeeId(int feeId) {
        List<FeeDO> feeDOList = feeRepository.getFeeDOByFeeId(feeId);
        if (feeDOList != null) {
            return studentMapper.mapToFee(feeDOList);
        }else {
            return null;
        }
    }


    public List<Fee> getFeeListByFeeIdAndMonthName(int feeId, String keyword) {
        List<FeeDO> feeDOList = feeRepository.getFeeDOByFeeIdAndMonthName(feeId,keyword);
        if (feeDOList != null){
            return studentMapper.mapToFee(feeDOList);
        }else {
            return null;
        }
    }
}
