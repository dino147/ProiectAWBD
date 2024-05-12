package com.dino14.proiectpwj.controller;

import com.dino14.proiectpwj.dto.EmployeeDTO;
import com.dino14.proiectpwj.mapper.EmployeeMapper;
import com.dino14.proiectpwj.model.Employee;
import com.dino14.proiectpwj.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ActiveProfiles("h2")
@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerIT {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private EmployeeMapper employeeMapper;

    @Test
    public void createEmployee() throws Exception {

        // arrange
        EmployeeDTO employeeDTO = new EmployeeDTO("Ionita", "Georgescu", "4444", 5000.0, "dummmy", "dummy");
        Employee employee = new Employee("Ionita", "Georgescu", "4444", 5000.0, "dummmy", "dummy");
        when(employeeService.saveEmployee(employee)).thenReturn(employee);

        // act
        // assert
        mockMvc.perform
                (post("/employee/new")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(employeeDTO)))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());// .andExpect(jsonPath("$.lastName").value(employee.getLastName()));

    }
}
