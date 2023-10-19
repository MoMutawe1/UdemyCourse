package com.udemy.service;

import com.udemy.exception.EmployeeNotFoundException;
import com.udemy.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> empList = new ArrayList<Employee>();

    @Override
    public Employee getEmployeeById(String id) throws EmployeeNotFoundException {
        //return empList.stream().filter((e) -> e.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Employee with Id: " + id + " is not exist."));
        return empList.stream().filter((e) -> e.getId().equals(id)).findFirst().orElseThrow(() -> new EmployeeNotFoundException("Employee with Id: " + id + " is not exist."));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empList;
    }

    @Override
    public Employee save(Employee employee) {
        if(employee.getId() == null || employee.getId().isEmpty())
            employee.setId(UUID.randomUUID().toString());
        empList.add(employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String id) throws EmployeeNotFoundException {
        Employee emp = empList.stream().filter((e) -> e.getId().equals(id)).findFirst().orElseThrow(() -> new EmployeeNotFoundException("Employee with Id: " + id + " is not exist."));
        empList.remove(emp);
        return "Employee with Id: " + id + " was deleted.";
    }
}
