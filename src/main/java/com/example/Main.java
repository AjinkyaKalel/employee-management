package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\\n=== Employee Management System ===");
                System.out.println("1. Add employee");
                System.out.println("2. View all employees");
                System.out.println("3. Search employee by ID");
                System.out.println("4. Delete employee");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number.");
                    continue;
                }

                switch (choice) {
                    case 1 -> {
                        try {
                            System.out.print("Employee ID: ");
                            int id = Integer.parseInt(scanner.nextLine());
                            System.out.print("Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Department: ");
                            String department = scanner.nextLine();
                            System.out.print("Salary: ");
                            double salary = Double.parseDouble(scanner.nextLine());
                            manager.addEmployee(new Employee(id, name, department, salary));
                            System.out.println("Employee added.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Could not add employee: " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        if (manager.getAllEmployees().isEmpty()) {
                            System.out.println("No employees found.");
                        } else {
                            manager.getAllEmployees().forEach(System.out::println);
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter employee ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        Employee employee = manager.findEmployee(id);
                        System.out.println(employee == null ? "Employee not found." : employee);
                    }
                    case 4 -> {
                        System.out.print("Enter employee ID to delete: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.println(manager.removeEmployee(id)
                                ? "Employee deleted." : "Employee not found.");
                    }
                    case 5 -> {
                        System.out.println("Goodbye.");
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            }
        }
    }
}
