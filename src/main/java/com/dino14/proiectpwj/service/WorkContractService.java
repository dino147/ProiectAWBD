package com.dino14.proiectpwj.service;

import com.dino14.proiectpwj.model.Company;
import com.dino14.proiectpwj.model.Employee;
import com.dino14.proiectpwj.model.WorkContract;
import com.dino14.proiectpwj.repository.CompanyRepository;
import com.dino14.proiectpwj.repository.EmployeeRepository;
import com.dino14.proiectpwj.repository.WorkContractRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class WorkContractService {

    private final WorkContractRepository workContractRepository;

    private final EmployeeRepository employeeRepository;

    private final CompanyRepository companyRepository;

    public WorkContractService(WorkContractRepository workContractRepository, EmployeeRepository employeeRepository, CompanyRepository companyRepository) {
        this.workContractRepository = workContractRepository;
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }

    public WorkContract saveWorkContract(WorkContract workContract, Long employeeId, Long companyId)
    {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Invalid employee id !"));
        //Optional<Company> company = companyRepository.findById(companyId);
        //if(company.isEmpty)
        //  throw new RuntimeException("Invalid company id !");
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Invalid company id !"));
        workContract.setEmployee(employee);
        workContract.setCompany(company);

        WorkContract savedWorkContract = workContractRepository.save(workContract);
        log.info("Saved work contract with id " + savedWorkContract.getWorkContractId() +
                 " for employee id " + employeeId + " and company id " + companyId);
        return savedWorkContract;
    }

    public List<WorkContract> listWorkContractsOnPage(int pageSize, int pageNumber)
    {
        Page<WorkContract> workContractPage = workContractRepository.findAll(Pageable.ofSize(pageSize).withPage(pageNumber));

        log.info("Listing work contracts on page " + pageNumber + " with page size " + pageSize);
        return workContractPage.toList();
    }
    public List<WorkContract> retrieveAllContracts()
    {
        List<WorkContract> workContracts = workContractRepository.findAll();

        log.info("Listing all work contracts, size: " + workContracts.size());
        return workContracts;
    }

    public List<WorkContract> findWorkContractsByEmployeeName(String firstName, String lastName)
    {
        List<WorkContract> workContracts = workContractRepository.findAll().stream()
                .filter(workContract -> Objects.equals(workContract.getEmployee().getFirstName(), firstName)
                        && Objects.equals(workContract.getEmployee().getLastName(), lastName)).collect(Collectors.toList());

        log.info("Found " + workContracts.size() + " work contracts for employee " + firstName + " " + lastName);
        return workContracts;
    }

    public List<WorkContract> deleteWorkContractById(Long workContractId)
    {
        workContractRepository.deleteById(workContractId);

        log.info("Deleted work contract with id: " + workContractId);
        return workContractRepository.findAll();
    }
}
