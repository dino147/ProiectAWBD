package com.dino14.proiectpwj.mapper;

import com.dino14.proiectpwj.dto.CompanyDTO;
import com.dino14.proiectpwj.model.Company;
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
