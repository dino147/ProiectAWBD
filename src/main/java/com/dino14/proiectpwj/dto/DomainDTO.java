package com.dino14.proiectpwj.dto;

public class DomainDTO {

    private String name;

    private int caenCode;

    public DomainDTO() {
    }

    public DomainDTO(String name, int caenCode) {
        this.name = name;
        this.caenCode = caenCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCaenCode() {
        return caenCode;
    }

    public void setCaenCode(int caenCode) {
        this.caenCode = caenCode;
    }
}
