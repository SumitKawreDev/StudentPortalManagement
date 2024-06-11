package com.example.studentportalmanagement.Controller;

import com.example.studentportalmanagement.Model.Student;
import com.example.studentportalmanagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/student/{id}", produces = "application/json")
    public Student getStudentById(@PathVariable int id){return studentService.getStudentById(id);}

    @PostMapping(value = "/student/save",consumes = "application/json")
    public String saveStudent(@RequestBody Student student){return studentService.saveStudent(student);}


}
