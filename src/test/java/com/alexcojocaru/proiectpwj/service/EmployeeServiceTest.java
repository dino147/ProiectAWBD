package com.alexcojocaru.proiectpwj.service;


import com.alexcojocaru.proiectpwj.model.Employee;
import com.alexcojocaru.proiectpwj.repository.EmployeeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("Running save employee behaviour")
    public void saveEmployeeTest(){
        // arrange - setup-ul pe care il facem in testul curent + obiecte de care avem nevoie
        Employee employee = new Employee("dummy1", "dummy2", "123", 1000.0, "dummmy3", "dummy4");
        when(employeeRepository.save(employee)).thenReturn(employee);

        // act - apelul in sine al injectului
        Employee result = employeeService.saveEmployee(employee);

        // assert - ceva ce vrem sa verificam
        assertEquals(employee.getFirstName(), result.getFirstName());
    }

    @Test
    public void saveSomeEmployeeTest() {
        // arrange

        // act
        RuntimeException result = assertThrows(
                RuntimeException.class,
                () -> employeeService.saveSomeEmployees());

        // assert
        assertEquals(result.getMessage(), "i = 5 !!!!", "Should be equals");
    }
}
