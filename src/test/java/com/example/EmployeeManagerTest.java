package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerTest {
    @Test
    void addsAndFindsEmployee() {
        EmployeeManager manager = new EmployeeManager();
        Employee employee = new Employee(1, "Asha", "IT", 35000);
        manager.addEmployee(employee);

        assertEquals("Asha", manager.findEmployee(1).getName());
        assertEquals(1, manager.getAllEmployees().size());
    }

    @Test
    void rejectsDuplicateIds() {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(new Employee(1, "Asha", "IT", 35000));

        assertThrows(IllegalArgumentException.class,
                () -> manager.addEmployee(new Employee(1, "Ravi", "HR", 30000)));
    }

    @Test
    void removesEmployee() {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(new Employee(2, "Ravi", "HR", 30000));

        assertTrue(manager.removeEmployee(2));
        assertNull(manager.findEmployee(2));
    }
}
