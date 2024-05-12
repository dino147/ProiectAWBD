package com.dino14.proiectpwj.controller;

import com.dino14.proiectpwj.dto.InvoiceDTO;
import com.dino14.proiectpwj.mapper.InvoiceMapper;
import com.dino14.proiectpwj.model.Invoice;
import com.dino14.proiectpwj.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//@RestController
@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    public final InvoiceService invoiceService;

    public final InvoiceMapper invoiceMapper;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
        this.invoiceMapper = new InvoiceMapper();
    }

    @RequestMapping({"", "/"})
    public String listInvoices(Model model)
    {
        List<InvoiceDTO> invoiceList = invoiceService.listInvoicesOnPage(3, 0);
        model.addAttribute("invoices", invoiceList);

        return "invoiceList";
    }


    @PostMapping("/new")
    public ResponseEntity<Invoice> addNewInvoice(@RequestBody @Valid InvoiceDTO invoiceDTO,
                                                 @RequestParam Long issuerId,
                                                 @RequestParam Long recipientId) {

        Invoice invoice = invoiceService.saveInvoice(invoiceMapper.convertRequestToInvoice(invoiceDTO),
                                                     issuerId, recipientId);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/invoice/{id}")
                .buildAndExpand(invoice.getInvoiceId())
                .toUri();

        return ResponseEntity.ok().body(invoice);
    }

    @GetMapping("/list")
    public ResponseEntity<List<InvoiceDTO>> listAllInvoices() {
        return ResponseEntity.ok().body(invoiceService.retrieveAllInvoices());
    }

    @GetMapping("/byIssuer/{companyName}")
    public ResponseEntity<List<Invoice>> getInvoicesByIssuerName(@PathVariable String companyName) {
        return ResponseEntity.ok().body(invoiceService.findInvoicesByIssuerName(companyName));
    }

    @DeleteMapping("/remove/{invoiceId}")
    public ResponseEntity<List<InvoiceDTO>> deleteWorkContract(@PathVariable Long invoiceId) {
        return ResponseEntity.ok().body(invoiceService.retrieveAllInvoices());
    }

    @PutMapping("/put/{invoiceId}")
    public ResponseEntity<Invoice> changeInvoice(@RequestBody @Valid InvoiceDTO invoiceDTO,
                                                 @PathVariable Long invoiceId) {

        Invoice invoice = invoiceService.modifyInvoice(invoiceMapper.convertRequestToInvoice(invoiceDTO), invoiceId);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/invoice/{id}")
                .buildAndExpand(invoice.getInvoiceId())
                .toUri();

        return ResponseEntity.created(location).body(invoice);
    }

}
