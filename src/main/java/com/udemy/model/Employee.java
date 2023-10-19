package com.udemy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    private String id;
    private String first_name;
    private String last_name;
    private String email_id;
    private String department;
}
