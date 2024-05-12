package com.dino14.proiectpwj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int domainId;

    private String name;

    private int caenCode;

    public Domain() {
    }
    public Domain(String name, int caenCode) {
        this.name = name;
        this.caenCode = caenCode;
    }

//    public Domain(int domainId, String name, int caenCode) {
//        this.domainId = domainId;
//        this.name = name;
//        this.caenCode = caenCode;
//    }
//
//
//    public int getDomainId() {
//        return domainId;
//    }
//
//    public void setDomainId(int domainId) {
//        this.domainId = domainId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getCaenCode() {
//        return caenCode;
//    }
//
//    public void setCaenCode(int caenCode) {
//        this.caenCode = caenCode;
//    }
}
