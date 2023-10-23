package com.udemy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String id;
    private String first_name;
    private String last_name;
    private String email_id;
    private String department;
}
