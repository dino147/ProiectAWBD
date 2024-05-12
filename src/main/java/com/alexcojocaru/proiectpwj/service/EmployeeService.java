package com.alexcojocaru.proiectpwj.service;

import com.alexcojocaru.proiectpwj.model.Employee;
import com.alexcojocaru.proiectpwj.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        log.info("Saved employee " + savedEmployee.getFirstName() + " " + savedEmployee.getLastName()
                + " with id " + savedEmployee.getEmployeeId());
        return savedEmployee;
    }

    public List<Employee> listEmployeeOnPage(int pageSize, int pageNumber) {
        Page<Employee> employeePage = employeeRepository.findAll(Pageable.ofSize(pageSize).withPage(pageNumber));
        log.info("Listing employees on page " + pageNumber + " with page size " + pageSize);

        return employeePage.toList();
    }

    public List<Employee> retrieveAllEmployees()
    {
        List<Employee> employeeList = employeeRepository.findAll(Sort.by("lastName"));
        log.info("Retrieving all employees, list size: " + employeeList.size());
        return employeeList;
    }

    public List<Employee> findEmployeeByFirstName(String firstName)
    {
        List<Employee> employeeList = employeeRepository.findByFirstName(firstName);

        log.info("Listing employees with first name " + firstName + " number: " + employeeList.size());
        return employeeList;
    }

    public Employee findEmployeeByFirstAndLastNames(String firstName, String lastName)
    {
        Optional<Employee> employeeOptional = employeeRepository.findByFirstNameAndLastName(firstName, lastName);

        if(employeeOptional.isEmpty())
            throw new RuntimeException("Employee with " + firstName + " " + lastName + "not found !");

        log.info("Found employee " + firstName + " " + lastName + " with id " + employeeOptional.get().getEmployeeId());
        return employeeOptional.get();
    }

    @Transactional
    public void saveSomeEmployees()
    {
        // for testing purposes
        for(int i = 0; i < 10; i++)
        {
            Employee employee = new Employee("dummy" + i, "dummy2", "123", 1000.0, "dummmy3", "dummy4");

            log.info("Savind employee with id: " + employee.getEmployeeId());
            if(i == 5){
                throw new RuntimeException("i = 5 !!!!");
            }
        }
    }
}
