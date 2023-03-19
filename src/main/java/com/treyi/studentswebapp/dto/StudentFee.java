package com.treyi.studentswebapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentFee {
    private Integer studentId;

    private Double fees;

    private Date paymentDate;
}
