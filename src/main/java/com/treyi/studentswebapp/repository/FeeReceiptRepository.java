package com.treyi.studentswebapp.repository;

import com.treyi.studentswebapp.model.FeeRecipt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeeReceiptRepository extends JpaRepository<FeeRecipt, UUID> {
}
