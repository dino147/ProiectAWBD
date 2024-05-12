package com.alexcojocaru.proiectpwj.service;

import com.alexcojocaru.proiectpwj.model.Company;
import com.alexcojocaru.proiectpwj.model.Domain;
import com.alexcojocaru.proiectpwj.repository.CompanyRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {

    @InjectMocks
    private CompanyService companyService;

    @Mock
    private CompanyRepository companyRepository;

    @Test
    @DisplayName("Running save company")
    public void saveCompanyTest()
    {
        // arrange
        Domain domain = new Domain("Cultivare", 111);
        Company company = new Company("TestName", "Director1", "SRL", domain);

        when(companyRepository.save(company)).thenReturn(company);

        // act
        Company result = companyService.saveCompany(company);

        // assert
        assertEquals(company.getName(), result.getName());
    }
}
