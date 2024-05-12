package com.alexcojocaru.proiectpwj.mapper;

import com.alexcojocaru.proiectpwj.dto.CompanyDTO;
import com.alexcojocaru.proiectpwj.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public Company convertRequestToCompany(CompanyDTO companyDTO)
    {
        return new Company(companyDTO.getName(),
                           companyDTO.getDirector(),
                           companyDTO.getType(),
                           companyDTO.getDomain());
    }
}
