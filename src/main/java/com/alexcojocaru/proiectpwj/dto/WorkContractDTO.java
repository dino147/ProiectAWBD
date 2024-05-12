package com.alexcojocaru.proiectpwj.dto;

import com.alexcojocaru.proiectpwj.model.Employee;
import com.alexcojocaru.proiectpwj.model.Company;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class WorkContractDTO {

    private Employee employee;

    private Company company;

    @NotNull(message = "Contract's norm cannot be null !")
    @NotBlank(message = "Contract's norm cannot be blank !")
    private String norm;

    @NotNull(message = "Contract's type cannot be null !")
    @NotBlank(message = "Contract's type cannot be blank !")
    private String type;

    @NotNull(message = "Contract's duration cannot be null !")
    @NotBlank(message = "Contract's duration cannot be blank !")
    private String duration;

    @Min(message = "Salary must be greater than minimum salary (500) !", value = 500)
    private float salary;

    public WorkContractDTO() {
    }

    public WorkContractDTO(Employee employee, Company company, String norm, String type, String duration, float salary) {
        this.employee = employee;
        this.company = company;
        this.norm = norm;
        this.type = type;
        this.duration = duration;
        this.salary = salary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getNorm() {
        return norm;
    }

    public void setNorm(String norm) {
        this.norm = norm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
