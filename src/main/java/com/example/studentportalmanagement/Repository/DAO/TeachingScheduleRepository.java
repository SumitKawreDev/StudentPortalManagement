package com.example.studentportalmanagement.Repository.DAO;

import com.example.studentportalmanagement.Repository.Do.TeachingScheduleDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeachingScheduleRepository extends JpaRepository<TeachingScheduleDO,Integer> {
    TeachingScheduleDO getTeachingScheduleByTeachingScheduleId(int teachingScheduleId);

//    TeachingScheduleDO getTeachingScheduleDOByTeachingScheduleId(int teachingScheduleId);
}
