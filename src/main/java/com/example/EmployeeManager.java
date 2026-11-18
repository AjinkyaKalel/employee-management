package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        if (findEmployee(employee.getId()) != null) {
            throw new IllegalArgumentException("Employee ID already exists.");
        }
        employees.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return List.copyOf(employees);
    }

    public Employee findEmployee(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean removeEmployee(int id) {
        return employees.removeIf(employee -> employee.getId() == id);
    }
}
