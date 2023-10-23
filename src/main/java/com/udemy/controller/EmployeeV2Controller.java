package com.udemy.controller;

import com.udemy.exception.EmployeeNotFoundException;
import com.udemy.model.Employee;
import com.udemy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/V2/employees")
public class EmployeeV2Controller {

    @Autowired
    @Qualifier("employeeV2ServiceImpl")
    private EmployeeService employeeService;

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id) throws EmployeeNotFoundException {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable String id) throws EmployeeNotFoundException {
        return employeeService.deleteEmployeeById(id);
    }
}
