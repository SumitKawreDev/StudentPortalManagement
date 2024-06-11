package com.example.studentportalmanagement.Repository.DAO;

import com.example.studentportalmanagement.Model.LoginDetails;
import com.example.studentportalmanagement.Repository.Do.LoginDetailsDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDetailsRepository extends JpaRepository<LoginDetailsDO,Integer> {

    LoginDetailsDO getLoginDetailsDOByUserName(String userName);
//    LoginDetailsDO getLoginDetailsDOByStudentId(int studentId);
}
