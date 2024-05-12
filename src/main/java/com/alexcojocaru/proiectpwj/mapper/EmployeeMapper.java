package com.alexcojocaru.proiectpwj.mapper;

import com.alexcojocaru.proiectpwj.dto.EmployeeDTO;
import com.alexcojocaru.proiectpwj.model.Employee;
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
