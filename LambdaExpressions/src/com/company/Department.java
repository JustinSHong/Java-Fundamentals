package com.company;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<EmployeeFunc> employees;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public void addEmployee(EmployeeFunc employee) {
        employees.add(employee);
    }

    public List<EmployeeFunc> getEmployees() {
        return employees;
    }
}
