package com.udemy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tbl_employee")
public class EmployeeEntity {
    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String email_id;
    private String department;
}
