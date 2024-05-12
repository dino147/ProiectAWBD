package com.dino14.proiectpwj.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long companyId;

    private String name;

    private String director;

    private String type;

    @OneToOne
    @JoinColumn(name = "domain_id")
    private Domain domain;

    @OneToMany(mappedBy = "issuer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Invoice> suplierInvoices = new HashSet(0);

    @OneToMany(mappedBy = "recipient")
    private Set<Invoice> customerInvoices = new HashSet(0);

    public Company() {
    }

    public Company(String name, String director, String type, Domain domain) {
        this.name = name;
        this.director = director;
        this.type = type;
        this.domain = domain;
    }

//
//    public Company(long companyId, String name, String director, String type, Domain domain) {
//        this.companyId = companyId;
//        this.name = name;
//        this.director = director;
//        this.type = type;
//        this.domain = domain;
//    }
//
//
//    public long getCompanyId() {
//        return companyId;
//    }
//
//    public void setCompanyId(long companyId) {
//        this.companyId = companyId;
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
//    public String getDirector() {
//        return director;
//    }
//
//    public void setDirector(String director) {
//        this.director = director;
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
//    public Domain getDomain() {
//        return domain;
//    }
//
//    public void setDomain(Domain domain) {
//        this.domain = domain;
//    }
}
