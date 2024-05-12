package com.alexcojocaru.proiectpwj.repository;

import com.alexcojocaru.proiectpwj.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public List<Employee> findByFirstName(String firstName);

    public Optional<Employee> findByFirstNameAndLastName(String firstName, String lastName);
}
