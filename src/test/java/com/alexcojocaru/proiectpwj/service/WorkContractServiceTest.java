package com.alexcojocaru.proiectpwj.service;

import com.alexcojocaru.proiectpwj.model.Company;
import com.alexcojocaru.proiectpwj.model.Domain;
import com.alexcojocaru.proiectpwj.model.Employee;
import com.alexcojocaru.proiectpwj.model.WorkContract;
import com.alexcojocaru.proiectpwj.repository.CompanyRepository;
import com.alexcojocaru.proiectpwj.repository.EmployeeRepository;
import com.alexcojocaru.proiectpwj.repository.WorkContractRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WorkContractServiceTest {

    @InjectMocks
    private WorkContractService workContractService;

    @Mock
    private WorkContractRepository workContractRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private CompanyRepository companyRepository;

    @Test
    @DisplayName("Running save work contract")
    public void saveWorkContractTest()
    {
        // arrange
        Long employeeId = 1L;
        Long companyId = 2L;

        Employee employee = new Employee("dummy1", "dummy2", "123", 1000.0, "dummmy3", "dummy4");
        Domain domain = new Domain("Cultivare", 111);
        Company company = new Company("TestName", "Director1", "SRL", domain);
        WorkContract workContract = new WorkContract(null, null, "test1", "test2", "test3", 3000.0f);

        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee)); // returns the employee for the id
        when(companyRepository.findById(companyId)).thenReturn(Optional.of(company));
        when(workContractRepository.save(workContract)).thenReturn(workContract);

        // act
        WorkContract result = workContractService.saveWorkContract(workContract, employeeId, companyId);

        // assert
        assertEquals(result.getEmployee().getFirstName(), employee.getFirstName(), "Should be equals");
        assertEquals(result.getCompany().getName(), company.getName(), "Should be equals");
        assertEquals(result.getSalary(), workContract.getSalary(), "Should be equals");

    }
}
