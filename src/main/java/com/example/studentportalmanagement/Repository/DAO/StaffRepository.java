package com.example.studentportalmanagement.Repository.DAO;

import com.example.studentportalmanagement.Repository.Do.LoginDetailsDO;
import com.example.studentportalmanagement.Repository.Do.StaffDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StaffRepository extends JpaRepository<StaffDO,Integer> {
//    StaffDO getStaffByUserName(String userName);
//
//    StaffDO getStaffByloginDetailsDO(int loginDetailsDO);

//    StaffDO getStaffByStaffDO(StaffDO staffDO);

    StaffDO getStaffDOByStaffId(int staffId);

//    @Modifying
//    @Query("update Staff s set s.staffId = ?1, s.address = ?2, s.contactNumber = ?3, s.dateOfBirth = ?4, s.gender = ?5, s.staffStatus = ?6, s.staffRole = ?7,s.email = ?8,s.staffName = ?9 where s.id = ?10")
//    void setStaffById(int staffId, String address, long contactNumber,String dateOfBirth,String gender,String staffStatus,String staffRole, String email,String staffName);
}
