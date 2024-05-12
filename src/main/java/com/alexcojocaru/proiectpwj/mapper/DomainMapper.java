package com.alexcojocaru.proiectpwj.mapper;

import com.alexcojocaru.proiectpwj.dto.DomainDTO;
import com.alexcojocaru.proiectpwj.model.Domain;
import org.springframework.stereotype.Component;

@Component
public class DomainMapper {
    public Domain convertRequestToDomain(DomainDTO domainDTO) {
        return new Domain(domainDTO.getName(),
                          domainDTO.getCaenCode());
    }
}
