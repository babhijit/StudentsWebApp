package com.treyi.studentswebapp.service;

import com.treyi.studentswebapp.model.Grade;
import com.treyi.studentswebapp.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GradeSvc {

    private GradeRepository repository;

    public GradeSvc(GradeRepository repository) {
        this.repository = repository;
    }

    public Grade save(Grade grade) {
        return repository.save(grade);
    }

    public List<Grade> findAllGrades() {
        return repository.findAll();
    }

    public Optional<Grade> findGrade(String name, String section) {
        return repository.findByNameAndSection(name, section);
    }

    public Grade getGrade(String name, String section) {
        var grade = findGrade(name, section);

        return grade.orElseGet(() -> {
            var newGrade = new Grade();
            newGrade.setName(name);
            newGrade.setSection(section);
            return repository.save(newGrade);
        });
    }
}
