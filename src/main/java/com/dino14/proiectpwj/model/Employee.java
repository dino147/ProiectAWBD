package com.dino14.proiectpwj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    private String firstName;

    private String lastName;

    private String cnp;

    private double income;

    private String designation;

    private String profession;

    public Employee() {

    }

    public Employee(String firstName, String lastName, String cnp, double income, String designation, String profession) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.income = income;
        this.designation = designation;
        this.profession = profession;
    }

//    public Employee(int employeeId, String firstName, String lastName, String cnp, double income, String designation, String profession) {
//        this.employeeId = employeeId;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.cnp = cnp;
//        this.income = income;
//        this.designation = designation;
//        this.profession = profession;
//    }
//
//
//    public long getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(int employeeId) {
//        this.employeeId = employeeId;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getCnp() {
//        return cnp;
//    }
//
//    public void setCnp(String cnp) {
//        this.cnp = cnp;
//    }
//
//    public double getIncome() {
//        return income;
//    }
//
//    public void setIncome(double income) {
//        this.income = income;
//    }
//
//    public String getDesignation() {
//        return designation;
//    }
//
//    public void setDesignation(String function) {
//        this.designation = function;
//    }
//
//    public String getProfession() {
//        return profession;
//    }
//
//    public void setProfession(String profession) {
//        this.profession = profession;
//    }
}
