package com.udemy.exception;

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException() {
       super("Employee is not exist.");
    }

    public EmployeeNotFoundException(String e) {
        super(e);
    }
}
