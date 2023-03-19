package com.treyi.studentswebapp.repository;

import com.treyi.studentswebapp.model.ClassFee;
import com.treyi.studentswebapp.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassFeeRepository extends JpaRepository<ClassFee, Integer> {
    Optional<ClassFee> findByGrade(Grade grade);
}
