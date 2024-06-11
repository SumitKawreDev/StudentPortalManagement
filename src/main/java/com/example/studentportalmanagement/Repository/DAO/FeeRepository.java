package com.example.studentportalmanagement.Repository.DAO;

import com.example.studentportalmanagement.Repository.Do.FeeDO;
import com.example.studentportalmanagement.Repository.Do.StudentDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FeeRepository extends JpaRepository<FeeDO,Integer> {

//    FeeDO getFeeByUserName(String userName);

    FeeDO getFeeByFeeId(int feeId);

    FeeDO getFeeByStudentDO(StudentDO studentDO);

    List<FeeDO> getFeeDOByStudentDO(StudentDO studentDO);

    List<FeeDO> getFeeDOByFeeId(int feeId);

//    List<FeeDO> search(String keyword);

    List<FeeDO> getFeeDOByMonthName(String monthName);

    List<FeeDO> getFeeDOByFeeIdAndMonthName(int feeId, String monthName);


//    FeeDO getFeeByUserName(Student student);


}
