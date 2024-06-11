package com.example.studentportalmanagement.Repository.DAO;

import com.example.studentportalmanagement.Model.Student;
import com.example.studentportalmanagement.Repository.Do.FeeDO;
import com.example.studentportalmanagement.Repository.Do.StaffDO;
import com.example.studentportalmanagement.Repository.Do.StudentDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentDO,Integer> {
//    @Query(value = "SELECT * FROM student t WHERE s.student_name = ?",
//            nativeQuery = true)
//    List<StudentDO> search(String keyword);


StudentDO getStudentDOByStudentId(int studentId);

//StudentDO getStudentDOByUserName(String username);

//    FeeDO getFeeByUserName(String username);
}
