package com.example.studentportalmanagement.Controller;

import com.example.studentportalmanagement.Model.Fee;
import com.example.studentportalmanagement.Model.LoginDetails;
import com.example.studentportalmanagement.Model.Student;
import com.example.studentportalmanagement.Repository.DAO.FeeRepository;
import com.example.studentportalmanagement.Repository.DAO.LoginDetailsRepository;
import com.example.studentportalmanagement.Repository.DAO.StudentRepository;
import com.example.studentportalmanagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController2 {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LoginDetailsRepository loginDetailsRepository;
    @Autowired
    private FeeRepository feeRepository;

    @GetMapping(value = "/student")
    public String viewHomePage(Model module) {
        module.addAttribute("student", studentService.getstudent());
        return "index";
    }

    @GetMapping("/register")
    public String registerNewStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "register";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student, Model model) {
        studentService.saveStudent(student);
        model.addAttribute("massage", "Registration Successful");
        return "redirect:/";
    }

//    @RequestMapping("/")
//    public String viewHomePage(Model model, @Param("keyword") String keyword) {
//        List<StudentDO> studentList = studentService.listAll(keyword);
//        model.addAttribute("student", studentList);
//        model.addAttribute("keyword", keyword);
//
//        return "index";
//    }

    @GetMapping("/login")
    public String loginStudent(Model model) {
        LoginDetails loginDetails = new LoginDetails();
        model.addAttribute("loginDetails", loginDetails);
        return "login";
    }

        @PostMapping("/login")
    public String loginStudent(@ModelAttribute("loginDetails") LoginDetails loginDetails, Model model) {
        Student response= studentService.loginStudent(loginDetails);
        if(null!=response){
            model.addAttribute("msg1", "Welcome ");
            model.addAttribute("studentId",response.getStudentId());
            model.addAttribute("student",response);

            return "welcomePage";
        }else {
            model.addAttribute("massage", "Invalid username or password");
            return "index";
        }
    }


//    @GetMapping("/login")
//    public String loginStudent(Model model) {
//        Student student = new Student();
//        model.addAttribute("student", student);
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String loginStudent(@ModelAttribute("student") Student student, Model model) {
//        Boolean response= studentService.loginStudent(student);
//        if(response){
//            model.addAttribute("msg1", "Welcome ");
//            model.addAttribute("msg", student.getUserName());
//            return "welcomePage";
//        }else {
//            model.addAttribute("massage", "Invalid username or password");
//            return "index";
//        }
//    }

    @GetMapping("/profile")
    public String studentProfile(Model model) {
        LoginDetails loginDetails = new LoginDetails();
//        Student student = new Student();
        model.addAttribute("loginDetails", loginDetails);
        return "profile";
    }
    @PostMapping("/profile/{msg}")
    public String studentProfile(@PathVariable(name = "msg") int studentId, Model model) {
        Student response = studentService.studentProfile(studentId);
        if (null!=response) {
            model.addAttribute("studentId", response.getStudentId());
            model.addAttribute("student", response);
            return "profile";
        }else {
            return null;
        }
    }
    @PostMapping("/home/{msg}")
    public String studentHome(@PathVariable(name = "msg") int studentId, Model model) {
        model.addAttribute("msg1", "Welcome ");
        model.addAttribute("studentId", studentId);
//        model.addAttribute("msg", studentId);
        return "welcomePage";
    }
    @GetMapping("/feeDetails")
    public String feeStudent(Model model){
        Fee fee = new Fee();
        model.addAttribute("fee",fee);
        return "feeDetails";
    }
    @PostMapping("/feeDetails/{studentId}")
    public String feeStudent(@PathVariable(name = "studentId") int studentId, Model model){
        List<Fee> feeList = studentService.studentFee(studentId);
        if (null!=feeList && !feeList.isEmpty()) {
            model.addAttribute("studentId",studentId);
            model.addAttribute("feeList",feeList);
            return "feeDetails";
        }else {
            model.addAttribute("FeeAlert", "Fee Details Not Found");
            return "feeDetails";
        }
    }

    @PostMapping("/contactUs/{msg}")
    public String contactUs(@PathVariable(name = "msg") int studentId ,Model model){
        model.addAttribute("msg1", "Welcome ");
        model.addAttribute("msg", studentId);
        return "contactUs";
    }
    @PostMapping("/formInfo/{msg}")
    public String formInfo(@PathVariable(name = "msg") int studentId ,Model model){
        model.addAttribute("msg1", "Welcome ");
        model.addAttribute("msg", studentId);
        return "formInfo";
    }
}

