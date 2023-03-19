package com.treyi.studentswebapp.controller;

import com.treyi.studentswebapp.dto.StudentInfo;
import com.treyi.studentswebapp.model.Student;
import com.treyi.studentswebapp.service.StudentSvc;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentSvc service;

    public StudentController(StudentSvc service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Student add(@RequestBody StudentInfo studentInfo) {
        return service.save(studentInfo);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }
}
