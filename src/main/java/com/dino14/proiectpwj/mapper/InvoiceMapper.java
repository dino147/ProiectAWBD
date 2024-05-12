package com.dino14.proiectpwj.mapper;

import com.dino14.proiectpwj.dto.InvoiceDTO;
import com.dino14.proiectpwj.model.Invoice;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
public class InvoiceMapper {

    public Invoice convertRequestToInvoice(InvoiceDTO invoiceDTO)
    {
        Invoice invoice = new Invoice();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            Date date = formatter.parse(invoiceDTO.getDate());
            invoice.setDate(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        invoice.setRecipient(invoiceDTO.getRecipient());
        invoice.setIssuer(invoiceDTO.getIssuer());
        invoice.setNumber(invoiceDTO.getNumber());
        invoice.setSeries(invoiceDTO.getSeries());
        invoice.setTotal(invoiceDTO.getTotal());
        invoice.setVat(invoiceDTO.getVat());

        return invoice;
    }

    public InvoiceDTO convertInvoiceToDTO(Invoice invoice)
    {
        String date = invoice.getDate() != null ? invoice.getDate().toString() : "";
        InvoiceDTO invoiceDTO = new InvoiceDTO(invoice.getInvoiceId(), invoice.getIssuer(), invoice.getRecipient(), date,
                                        invoice.getSeries(), invoice.getNumber(), invoice.getTotal(), invoice.getVat());
        return invoiceDTO;
    }
}
