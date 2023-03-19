package com.treyi.studentswebapp.service;

import com.treyi.studentswebapp.model.Student;
import com.treyi.studentswebapp.model.StudentWallet;
import com.treyi.studentswebapp.repository.StudentWalletRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class WalletSvc {

    private StudentWalletRepository studentWalletRepository;

    public WalletSvc(StudentWalletRepository studentWalletRepository) {
        this.studentWalletRepository = studentWalletRepository;
    }

    public StudentWallet save(StudentWallet studentWallet) {
        return studentWalletRepository.save(studentWallet);
    }

    public Optional<StudentWallet> findStudentWallet(Student student) {
        return findStudentWallet(student.getId());
    }

    public Optional<StudentWallet> findStudentWallet(Integer studentId) {
        return studentWalletRepository.findById(studentId);
    }

    public List<StudentWallet> findAllStudentWallets() {
        return studentWalletRepository.findAll();
    }

    @Transactional(rollbackOn = Exception.class)
    public StudentWallet addBalance(Student student, Double amount) {
        if (amount <= 0) {
            throw new UnsupportedOperationException("Invalid amount!");
        }

        return adjustBalance(student, amount);
    }

    @Transactional(rollbackOn = Exception.class)
    public StudentWallet withdraw(Student student, Double amount) {
        if (amount <= 0) {
            throw new UnsupportedOperationException("Invalid amount!");
        }

        var wallet = adjustBalance(student, -amount);
        if (wallet.getBalance() <= 0) {
            throw new UnsupportedOperationException("Insufficient Balance");
        }

        return wallet;
    }

    private StudentWallet adjustBalance(Student student, Double amount) {
        var wallet = studentWalletRepository.findByStudent(student).get();
        var balance = wallet.getBalance();
        balance += amount;
        wallet.setBalance(balance);
        return studentWalletRepository.save(wallet);
    }
}
