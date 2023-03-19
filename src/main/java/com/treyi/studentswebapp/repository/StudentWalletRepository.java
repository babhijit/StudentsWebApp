package com.treyi.studentswebapp.repository;

import com.treyi.studentswebapp.model.Student;
import com.treyi.studentswebapp.model.StudentWallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentWalletRepository extends JpaRepository<StudentWallet, Integer> {
    Optional<StudentWallet> findByStudent(Student student);
}
