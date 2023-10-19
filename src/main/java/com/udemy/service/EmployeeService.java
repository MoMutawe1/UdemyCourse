package com.udemy.service;

import com.udemy.exception.EmployeeNotFoundException;
import com.udemy.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String id) throws EmployeeNotFoundException;
    String deleteEmployeeById(String id) throws EmployeeNotFoundException;
}
