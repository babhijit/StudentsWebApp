package com.treyi.studentswebapp.service;

import com.treyi.studentswebapp.dto.StudentFee;
import com.treyi.studentswebapp.model.FeeRecipt;
import com.treyi.studentswebapp.repository.ClassFeeRepository;
import com.treyi.studentswebapp.repository.FeeReceiptRepository;
import com.treyi.studentswebapp.repository.StudentRepository;
import com.treyi.studentswebapp.repository.StudentWalletRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
public class FeeSvc {

    private StudentRepository studentRepository;
    private ClassFeeRepository classFeeRepository;
    private WalletSvc walletService;

    private FeeReceiptRepository receiptRepository;

    public FeeSvc(StudentRepository studentRepository,
                  ClassFeeRepository classFeeRepository,
                  StudentWalletRepository studentWalletRepository, WalletSvc walletService) {
        this.studentRepository = studentRepository;
        this.classFeeRepository = classFeeRepository;
        this.walletService = walletService;
    }

    Optional<FeeRecipt> pay(StudentFee fee) {
        try {
            return Optional.of(transact(fee));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Transactional(rollbackOn = Exception.class)
    FeeRecipt transact(StudentFee studentFee) {
        Integer studentId = studentFee.getStudentId();
        var student = studentRepository.findById(studentId).get();
        var gradeFees = classFeeRepository.findByGrade(student.getGrade()).get();
        walletService.withdraw(student, gradeFees.getAmount());

        var feeReceipt = new FeeRecipt();
        feeReceipt.setFees(gradeFees.getAmount());
        feeReceipt.setStudent(student);
        feeReceipt.setPaymentDate(new Date());
        return receiptRepository.save(feeReceipt);
    }
}
