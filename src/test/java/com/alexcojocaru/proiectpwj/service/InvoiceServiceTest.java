package com.alexcojocaru.proiectpwj.service;

import com.alexcojocaru.proiectpwj.model.Company;
import com.alexcojocaru.proiectpwj.model.Domain;
import com.alexcojocaru.proiectpwj.model.Invoice;
import com.alexcojocaru.proiectpwj.repository.CompanyRepository;
import com.alexcojocaru.proiectpwj.repository.InvoiceRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InvoiceServiceTest {

    @InjectMocks
    private InvoiceService invoiceService;

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private CompanyRepository companyRepository;


    @Test
    public void saveInvoiceTest() {
        // arrange
        Long issuerId = 1L;
        Long recipientId = 2L;
        Domain domain = new Domain("Cultivare", 111);
        Company issuer = new Company("Issuer", "Director1", "SRL", domain);
        Company recipient = new Company("Recipient", "Director2", "SA", domain);
        Invoice invoice = new Invoice(issuer, recipient, null, "AA1", 1, 100.0f, 19.0f);

        when(companyRepository.findById(issuerId)).thenReturn(Optional.of(issuer));
        when(companyRepository.findById(recipientId)).thenReturn(Optional.of(recipient));
        when(invoiceRepository.save(invoice)).thenReturn(invoice);

        // act
        Invoice result = invoiceService.saveInvoice(invoice, issuerId, recipientId);

        // assert
        assertEquals(invoice.getIssuer().getName(), result.getIssuer().getName());
    }
}
