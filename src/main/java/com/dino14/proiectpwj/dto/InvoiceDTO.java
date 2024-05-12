package com.dino14.proiectpwj.dto;

import com.dino14.proiectpwj.model.Company;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDTO {

    private Long invoiceId;

    private Company issuer;

    private Company recipient;

    @NotNull(message = "Invoice date cannot be null !")
    @NotBlank(message = "Invoice date cannot be blank !")
    private String date;

    @NotNull(message = "Invoice series cannot be null !")
    @NotBlank(message = "Invoice series cannot be blank !")
    private String series;

    @Min(message = "Invoice number must be at least 1 !", value = 1)
    private long number;

    @Min(message = "Total must be positive !", value = 0)
    private float total;

    private float vat;

    public InvoiceDTO(Company issuer, Company recipient, String date, String series, long number, float total, float vat) {
        this.issuer = issuer;
        this.recipient = recipient;
        this.date = date;
        this.series = series;
        this.number = number;
        this.total = total;
        this.vat = vat;
    }
}
