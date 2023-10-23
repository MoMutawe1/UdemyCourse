package com.udemy.service;

import com.udemy.entity.EmployeeEntity;
import com.udemy.exception.EmployeeNotFoundException;
import com.udemy.model.Employee;
import com.udemy.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository repository;

    @Override
    public Employee save(Employee employee) {
        if(employee.getId() == null || employee.getId().isEmpty())
            employee.setId(UUID.randomUUID().toString());
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        repository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> empList = repository.findAll();

        List<Employee> employees = empList.stream().map(employeeEntity -> {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeEntity, employee);
            return employee;
        }).collect(Collectors.toList());

        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) throws EmployeeNotFoundException {
        EmployeeEntity employeeEntity = repository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String id) throws EmployeeNotFoundException {
        repository.deleteById(id);
        return "Employee with Id: " + id + ", has been deleted.";
    }
}
