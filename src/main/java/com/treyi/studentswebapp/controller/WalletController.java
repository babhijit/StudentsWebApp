package com.treyi.studentswebapp.controller;

import com.treyi.studentswebapp.model.StudentWallet;
import com.treyi.studentswebapp.service.WalletSvc;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    private WalletSvc service;

    public WalletController(WalletSvc service) {
        this.service = service;
    }

    @PostMapping("/add/student")
    @ResponseBody
    public StudentWallet addToWallet(@RequestBody StudentWallet studentWallet) {
        return service.save(studentWallet);
    }

    @GetMapping("/get/student")
    public ResponseEntity<StudentWallet> getStudentWallet(@RequestParam(name = "student_id") Integer studentId) {
        return service.findStudentWallet(studentId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
