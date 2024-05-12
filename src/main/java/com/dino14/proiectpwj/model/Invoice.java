package com.dino14.proiectpwj.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long invoiceId;

    @ManyToOne
    @JoinColumn(name = "issuer_id")//, insertable = false, updatable = false)
    private Company issuer;

    @ManyToOne
    @JoinColumn(name = "recipient_id")//, insertable = false, updatable = false)
    private Company recipient;

    private Date date;

    private String series;

    private long number;

    private float total;

    private float vat;

    public Invoice() {
    }

    public Invoice(Company issuer, Company recipient, Date date, String series, long number, float total, float vat) {
        this.invoiceId = invoiceId;
        this.issuer = issuer;
        this.recipient = recipient;
        this.date = date;
        this.series = series;
        this.number = number;
        this.total = total;
        this.vat = vat;
    }

//    public Invoice(long invoiceId, Company issuer, Company recipient, Date date, String series, long number, float total, float vat) {
//        this.invoiceId = invoiceId;
//        this.issuer = issuer;
//        this.recipient = recipient;
//        this.date = date;
//        this.series = series;
//        this.number = number;
//        this.total = total;
//        this.vat = vat;
//    }
//
//    public long getInvoiceId() {
//        return invoiceId;
//    }
//
//    public void setInvoiceId(long invoiceId) {
//        this.invoiceId = invoiceId;
//    }
//
//    public Company getIssuer() {
//        return issuer;
//    }
//
//    public void setIssuer(Company issuer) {
//        this.issuer = issuer;
//    }
//
//    public Company getRecipient() {
//        return recipient;
//    }
//
//    public void setRecipient(Company recipient) {
//        this.recipient = recipient;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public String getSeries() {
//        return series;
//    }
//
//    public void setSeries(String series) {
//        this.series = series;
//    }
//
//    public long getNumber() {
//        return number;
//    }
//
//    public void setNumber(long number) {
//        this.number = number;
//    }
//
//    public float getTotal() {
//        return total;
//    }
//
//    public void setTotal(float total) {
//        this.total = total;
//    }
//
//    public float getVat() {
//        return vat;
//    }
//
//    public void setVat(float vat) {
//        this.vat = vat;
//    }
}
