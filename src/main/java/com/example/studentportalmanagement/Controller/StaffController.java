package com.example.studentportalmanagement.Controller;

import com.example.studentportalmanagement.Model.LoginDetails;
import com.example.studentportalmanagement.Model.Staff;
import com.example.studentportalmanagement.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping(value = "/staff/{id}",produces = "application/json")
    public Staff getStaffById(@PathVariable int id){return staffService.getStaffById(id);}



}
