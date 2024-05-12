package com.alexcojocaru.proiectpwj.service;

import com.alexcojocaru.proiectpwj.model.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class EmployeeServiceIT {

    @Autowired
    private EmployeeService employeeService;

    @Test
    @DisplayName("Create Employee IT")
    public void createEmployee()
    {
        // arrange
        Employee employee = new Employee("dummy1", "dummy2", "123", 1000.0, "dummmy3", "dummy4");

        // act
        Employee result = employeeService.saveEmployee(employee);

        // assert
        assertEquals(employee.getLastName(), result.getLastName(), "should be equals");
    }
}
