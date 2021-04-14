package com.springrest.springrest.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private String employeeId;
    private String employeeName;
    private double employeeSalary;
    private DepartmentDto department;
    private int employeeExperience;
}
