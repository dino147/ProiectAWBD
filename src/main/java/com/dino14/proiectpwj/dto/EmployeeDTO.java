package com.dino14.proiectpwj.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeDTO {

    @NotNull(message = "Employee first name cannot be null !")
    @NotBlank(message = "Employee first name cannot be blank !")
    private String firstName;

    @NotNull(message = "Employee last name cannot be null !")
    @NotBlank(message = "Employee last name cannot be blank !")
    private String lastName;

    @NotNull(message = "Employee cnp cannot be null !")
    @NotBlank(message = "Employee cnp cannot be blank !")
    private String cnp;

    @Min(message = "Income can't be lower than 500 !", value = 500)
    private double income;

    @NotNull(message = "Employee designation cannot be null !")
    @NotBlank(message = "Employee designation cannot be blank !")
    private String designation;

    @NotNull(message = "Employee profession cannot be null !")
    @NotBlank(message = "Employee profession cannot be blank !")
    private String profession;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String firstName, String lastName, String cnp, double income, String designation, String profession) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.income = income;
        this.designation = designation;
        this.profession = profession;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
