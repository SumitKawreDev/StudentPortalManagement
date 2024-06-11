package com.example.studentportalmanagement.Repository.DAO;

import com.example.studentportalmanagement.Repository.Do.SalaryDO;
import com.example.studentportalmanagement.Repository.Do.StaffDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryRepository extends JpaRepository<SalaryDO,Integer> {

    SalaryDO getSalaryDOBySalaryId(int salaryId);

    List<SalaryDO> getSalaryDOByStaffDO(StaffDO staffDO);

    SalaryDO getSalaryDOBySalaryIdAndMonthName(int salaryId, String monthName);

    SalaryDO getSalaryDOByMonthNameAndStaffDO(String monthName, StaffDO staffDO);

    List<SalaryDO> getSalaryDOBySalaryStatusAndStaffDO(String salaryStatus, StaffDO staffDO);
}
