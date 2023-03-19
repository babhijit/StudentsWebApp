package com.treyi.studentswebapp.controller;

import com.treyi.studentswebapp.model.Grade;

import com.treyi.studentswebapp.service.GradeSvc;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/grade")
public class GradeController {

    private GradeSvc service;

    public GradeController(GradeSvc service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Grade save(@RequestBody Grade grade) {
        return service.save(grade);
    }

    @GetMapping("/getAll")
    public List<Grade> getAll() {
        return service.findAllGrades();
    }
}
