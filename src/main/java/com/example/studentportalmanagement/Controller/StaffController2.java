package com.example.studentportalmanagement.Controller;

import com.example.studentportalmanagement.Model.*;
import com.example.studentportalmanagement.Repository.Do.LoginDetailsDO;
import com.example.studentportalmanagement.Service.StaffService;
import com.example.studentportalmanagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StaffController2 {

    @Autowired
    private StaffService staffService;
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/staff")
    public String staffLogin(Model model){
        LoginDetails loginDetails =new LoginDetails();
        model.addAttribute("loginDetails", loginDetails);
        return "staffLoginPage";
    }
//    @PostMapping(value = "/staffLogin")
//    public String StaffLogin(@ModelAttribute("loginDetails") LoginDetails loginDetails, Model model){
//         String role = staffService.loginStaff(loginDetails);
//        if(role != null){
//            if(role.equals("teacher")){
//                TeachingSchedule teachingSchedule = staffService.teachingSchedule(loginDetails.getUserName());
//                model.addAttribute("msg1","Welcome to Staff Portal Home Page");
//                model.addAttribute("msg",loginDetails.getUserName());
//                model.addAttribute("teachingSchedule",teachingSchedule);
//                return "staffHome";
//            }else if(role.equals("admin")){
//                return "admin";
//            }else if(role.equals("staff")){
//                return "admin";
//            }
//        }else {
//            model.addAttribute("msg2","Invalid username or password");
//            return "staffLoginPage";
//        }
//    }


    @PostMapping(value = "/staffLogin")
    public String StaffLogin(@ModelAttribute("loginDetails") LoginDetails loginDetails, Model model){
        LoginDetails resultLoginDetails = staffService.loginStaff(loginDetails);
        String final_page = "";
        String role = resultLoginDetails.getStaffRole();
        if( null!= resultLoginDetails.getStaffRole()){
           if (role.equals("Teacher")){
               TeachingSchedule teachingSchedule = staffService.teachingSchedule(resultLoginDetails.getUserName());
               model.addAttribute("welcomeTeacherMsg","Welcome to Staff Portal Home Page");
               model.addAttribute("msg",loginDetails.getUserName());
               model.addAttribute("teachingSchedule",teachingSchedule);
               final_page = "staffHome";
           }else if(role.equals("Student")){
               Student student = studentService.studentProfile(resultLoginDetails.getStudentId());
               model.addAttribute("welcomeStudentMsg","Welcome to Student Portal ");
               model.addAttribute("msg",loginDetails.getUserName());
               model.addAttribute("studentId",student.getStudentId());
               final_page= "welcomePage";
           }else if(role.equals("Admin")){
               Staff staff = staffService.staffProfile(resultLoginDetails.getUserName());
               model.addAttribute("welcomeAdminMsg","Welcome to Admin Portal ");
               model.addAttribute("admin",resultLoginDetails.getUserName());
               final_page = "adminHomePage";
           }
        }else {
            model.addAttribute("msg2","Invalid username or password");
            final_page = "staffLoginPage";
        }
        return final_page;
    }
    @GetMapping(value = "/teachingSchedule")
    public String teachingSchedule(Model model){
        LoginDetails loginDetails =new LoginDetails();
        model.addAttribute("loginDetails", loginDetails);
        return "staffHome";
    }
    @PostMapping(value = "/teachingSchedule/{msg}")
    public String teachingSchedule(@PathVariable(name = "msg")String userName, Model model){
        TeachingSchedule response = staffService.teachingSchedule(userName);
        if(null!=response){
            model.addAttribute("teachingSchedule", response);
            return "staffHome";
        }else {
            model.addAttribute("errorMsg1","There is no teaching schedule");
            return "staffHome";
        }
    }

    @GetMapping(value = "/staffProfile")
    public String staffProfile(Model model){
        LoginDetails loginDetails = new LoginDetails();
        model.addAttribute("loginDetails", loginDetails);
        return "staffProfile";
    }

    @PostMapping(value = "/staffProfile/{msg}")
    public String staffProfile(@PathVariable(name = "msg")String userName, Model model){
        Staff response = staffService.staffProfile(userName);
        if(null!=response){
            model.addAttribute("staff", response);
            return "staffProfile";
        }else {
            return null;
        }


    }

    @GetMapping(value = "/staffSalary")
    public String staffSalary(Model model){
        LoginDetails loginDetails = new LoginDetails();
        model.addAttribute("loginDetails",loginDetails);
        return "staffSalary";
    }
    @PostMapping(value = "/staffSalary/{msg}")
    public String staffSalary(@PathVariable(name = "msg")String userName,Model model){
        Salary response = staffService.staffSalary(userName);
        if(null!=response){
            model.addAttribute("salary", response);
            return "staffSalary";
        }else {
            model.addAttribute("errorMsg","Salary not found");
            return "staffHome";
        }
    }

    @PostMapping("/logout/{studentId}")
    public String logout(@PathVariable("studentId")int studentId, Model model){
        model.addAttribute("studentId", studentId) ;
            return "staffLoginPage";
    }

}
