package com.alexcojocaru.proiectpwj.service;

import com.alexcojocaru.proiectpwj.dto.InvoiceDTO;
import com.alexcojocaru.proiectpwj.mapper.InvoiceMapper;
import com.alexcojocaru.proiectpwj.model.Company;
import com.alexcojocaru.proiectpwj.model.Invoice;
import com.alexcojocaru.proiectpwj.repository.CompanyRepository;
import com.alexcojocaru.proiectpwj.repository.InvoiceRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    private final CompanyRepository companyRepository;

    public final InvoiceMapper invoiceMapper;

    public InvoiceService(InvoiceRepository invoiceRepository, CompanyRepository companyRepository) {
        this.invoiceRepository = invoiceRepository;
        this.companyRepository = companyRepository;
        this.invoiceMapper = new InvoiceMapper();
    }

    public Invoice modifyInvoice(Invoice invoice, Long invoiceId)
    {
        Optional<Invoice> optChangedInvoice = invoiceRepository.findById(invoiceId);
        if(optChangedInvoice.isEmpty())
            throw new RuntimeException("Invalid issuer id !");

        Invoice changedInvoice = optChangedInvoice.get();

        //changedInvoice.setIssuer(invoice.getIssuer());
        //changedInvoice.setRecipient(invoice.getRecipient());
        changedInvoice.setNumber(invoice.getNumber());
        changedInvoice.setSeries(invoice.getSeries());
        changedInvoice.setDate(invoice.getDate());
        changedInvoice.setVat(invoice.getVat());
        changedInvoice.setTotal(invoice.getTotal());

        log.info("Changed invoice with id " + invoiceId);
        return invoiceRepository.save(changedInvoice);
    }

    public Invoice saveInvoice(Invoice invoice, Long issuerId, Long recipientId)
    {
        Optional<Company> issuer = companyRepository.findById(issuerId);
        Optional<Company> receipient = companyRepository.findById(recipientId);

        if(issuer.isEmpty())
            throw new RuntimeException("Invalid issuer id !");
        if(receipient.isEmpty())
            throw  new RuntimeException("Invalid receipient id !");

        invoice.setIssuer(issuer.get());
        invoice.setRecipient(receipient.get());

        Invoice savedInvoice = invoiceRepository.save(invoice);
        log.info("Saved invoice with id " + savedInvoice.getInvoiceId() + " for issuer " + issuerId + " and recipient " + recipientId);

        return savedInvoice;
    }

    public List<InvoiceDTO> listInvoicesOnPage(int pageSize, int pageNumber)
    {
        Page<Invoice> invoicePage = invoiceRepository.findAll(Pageable.ofSize(pageSize).withPage(pageNumber));
        log.info("Listing invoices on page " + pageNumber + " with page size " + pageSize);
        return invoicePage.stream()
                .map(invoiceMapper::convertInvoiceToDTO).collect(Collectors.toList());
    }

    public List<InvoiceDTO> retrieveAllInvoices() {
        List<Invoice> invoiceList = invoiceRepository.findAll();

        log.info("Retrieving all invoices, number: " + invoiceList.size());
        return invoiceList.stream()
                .map(invoiceMapper::convertInvoiceToDTO).collect(Collectors.toList());
    }

    public List<Invoice> findInvoicesByIssuerName(String name)
    {
        Optional<Company> issuer = companyRepository.findCompanyByName(name);
        if(issuer.isEmpty())
            throw new RuntimeException("Company with name " + name + " not found!");
        List<Invoice> invoiceList = invoiceRepository.findInvoicesByIssuer(issuer.get());

        log.info("Number of invoices found by issuer " + name + " : " + invoiceList.size());
        return invoiceList;
    }

    public List<Invoice> findInvoicesByIssuerAndRecipientNames(String issuerName, String recipientName)
    {
        List<Invoice> invoiceList = invoiceRepository.findInvoicesIssuerAndReceipientName(issuerName, recipientName);

        log.info("Number of invoices found by issuer and recipient: " + invoiceList.size());
        return invoiceList;
    }
}
