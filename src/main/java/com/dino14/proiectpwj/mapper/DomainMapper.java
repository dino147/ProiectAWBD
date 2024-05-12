package com.dino14.proiectpwj.mapper;

import com.dino14.proiectpwj.dto.DomainDTO;
import com.dino14.proiectpwj.model.Domain;
import org.springframework.stereotype.Component;

@Component
public class DomainMapper {
    public Domain convertRequestToDomain(DomainDTO domainDTO) {
        return new Domain(domainDTO.getName(),
                          domainDTO.getCaenCode());
    }
}
