package com.example.studentportalmanagement.Repository.Do;

import jakarta.persistence.*;

@Entity(name = "teaching_schedule")
public class TeachingScheduleDO {

    @Id
    @Column(name = "teaching_schedule_id")
    public int teachingScheduleId;

    @Column(name = "engage")
    public String engage;

    @Column(name = "class_name")
    public String className;

    @Column(name = "timing")
    public String timing;

    @Column(name = "sub")
    public String sub;

    @Column(name = "time_duration")
    public String timeDuration;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="staff_id")
    private StaffDO staffDO;

    public StaffDO getStaffDO() {
        return staffDO;
    }

    public void setStaffDO(StaffDO staffDO) {
        this.staffDO = staffDO;
    }

    public int getTeachingScheduleId() {
        return teachingScheduleId;
    }

    public void setTeachingScheduleId(int teachingScheduleId) {
        this.teachingScheduleId = teachingScheduleId;
    }

    public String getEngage() {
        return engage;
    }

    public void setEngage(String engage) {
        this.engage = engage;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(String timeDuration) {
        this.timeDuration = timeDuration;
    }



}
