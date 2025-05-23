package com.keyin.store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
    // test cases for employee
    //1 test creating
    //2 test updating
    //3 test deleting

    @Test
    void testEmployeeCreation() {
        Employee employee = new Employee(1, "John Doe","Manager");
        // Add assertions to verify the employee creation
        Assertions.assertEquals(1, employee.getEmployeeIdd());
        Assertions.assertEquals("John Doe", employee.getName());

    }

    @Test
    void testEmployeeUpdate() {
        Employee employee = new Employee(1, "John Doe","Manager");
        employee.setName("Jane Doe");
        employee.setPosition("Senior Manager");

        // Add assertions to verify the employee update
        Assertions.assertEquals("Jane Doe", employee.getName());
        Assertions.assertEquals("Senior Manager", employee.getPosition());
    }
    @Test
    void testEmployeeDeletion() {
        // Test deleting an employee
        Employee employee = new Employee(1, "John Doe","Manager");
        employee.setEmployeeIdd(0);
        employee.setName(null);
        employee.setPosition(null);

        Assertions.assertEquals(0, employee.getEmployeeIdd());
        Assertions.assertNull(employee.getName());
        Assertions.assertNull(employee.getPosition());
    }

}
