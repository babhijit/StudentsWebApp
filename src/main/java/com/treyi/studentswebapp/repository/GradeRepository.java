package com.treyi.studentswebapp.repository;

import com.treyi.studentswebapp.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

    Optional<Grade> findByNameAndSection(String name, String section);
}
