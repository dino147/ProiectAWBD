package com.alexcojocaru.proiectpwj.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class WorkContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long workContractId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private String norm;

    private String type;

    private String duration;

    private float salary;

    public WorkContract() {
    }

    public WorkContract(Employee employee, Company company, String norm, String type, String duration, float salary) {
        this.employee = employee;
        this.company = company;
        this.norm = norm;
        this.type = type;
        this.duration = duration;
        this.salary = salary;
    }

//
//    public WorkContract(long workContractId, Employee employee, Company company, String norm, String type, String duration, float salary) {
//        this.workContractId = workContractId;
//        this.employee = employee;
//        this.company = company;
//        this.norm = norm;
//        this.type = type;
//        this.duration = duration;
//        this.salary = salary;
//    }
//
//    public long getWorkContractId() {
//        return workContractId;
//    }
//
//    public void setWorkContractId(long workContractId) {
//        this.workContractId = workContractId;
//    }
//
//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
//
//    public Company getCompany() {
//        return company;
//    }
//
//    public void setCompany(Company company) {
//        this.company = company;
//    }
//
//    public String getNorm() {
//        return norm;
//    }
//
//    public void setNorm(String norm) {
//        this.norm = norm;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getDuration() {
//        return duration;
//    }
//
//    public void setDuration(String duration) {
//        this.duration = duration;
//    }
//
//    public float getSalary() {
//        return salary;
//    }
//
//    public void setSalary(float salary) {
//        this.salary = salary;
//    }
}
