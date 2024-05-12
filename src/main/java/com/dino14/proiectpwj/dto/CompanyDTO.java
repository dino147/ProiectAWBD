package com.dino14.proiectpwj.dto;

import com.dino14.proiectpwj.model.Domain;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CompanyDTO {

    @NotNull(message = "Company name cannot be null !")
    @NotBlank(message = "Company name cannot be blank !")
    private String name;

    @NotNull(message = "Company director name cannot be null !")
    @NotNull(message = "Company director name cannot be blank !")
    private String director;

    @NotNull(message = "Company type name cannot be null !")
    @NotNull(message = "Company type name cannot be blank !")
    private String type;

    private Domain domain;

    public CompanyDTO() {
    }

    public CompanyDTO(String name, String director, String type, Domain domain) {
        this.name = name;
        this.director = director;
        this.type = type;
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }
}
