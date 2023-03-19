package com.treyi.studentswebapp.service;

import com.treyi.studentswebapp.dto.StudentInfo;
import com.treyi.studentswebapp.model.Grade;
import com.treyi.studentswebapp.model.Student;
import com.treyi.studentswebapp.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSvc {

    private final StudentRepository repository;

    private final GradeSvc gradeSvc;

    public StudentSvc(StudentRepository repository, GradeSvc gradeSvc) {
        this.repository = repository;
        this.gradeSvc = gradeSvc;
    }

    public Student save(StudentInfo studentInfo) {
        var studentGrade = new Grade();
        studentGrade.setName(studentInfo.getGrade());
        studentGrade.setSection(studentInfo.getSection());

        var grade = gradeSvc.getGrade(studentInfo.getGrade(), studentInfo.getSection());
        var student = new Student(studentInfo.getId(), studentInfo.getName(), studentInfo.getAddress(), grade);
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }
}
