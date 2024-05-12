package com.dino14.proiectpwj.repository;

import com.dino14.proiectpwj.model.Company;
import com.dino14.proiectpwj.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    public List<Invoice> findInvoicesByIssuer(Company company);

    public List<Invoice> findInvoicesByRecipient(Company company);

    @Query("select i from Invoice i where i.issuer.name = :issuerName and i.recipient.name = :recipientName")
    public List<Invoice> findInvoicesIssuerAndReceipientName(@Param("issuerName") String issuerName, @Param("recipientName") String recipientName);
}
