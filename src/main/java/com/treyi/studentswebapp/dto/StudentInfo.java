package com.treyi.studentswebapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInfo {
    private int id;

    private String name;

    private String address;

    private String grade;

    private String section;
}
