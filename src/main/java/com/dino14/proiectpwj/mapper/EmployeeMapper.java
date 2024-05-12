package com.dino14.proiectpwj.mapper;

import com.dino14.proiectpwj.dto.EmployeeDTO;
import com.dino14.proiectpwj.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee convertRequestToEmployee(EmployeeDTO employeeDTO)
    {
        return new Employee(employeeDTO.getFirstName(),
                            employeeDTO.getLastName(),
                            employeeDTO.getCnp(),
                            employeeDTO.getIncome(),
                            employeeDTO.getDesignation(),
                            employeeDTO.getProfession());
    }
}
