package com.dino14.proiectpwj.mapper;

import com.dino14.proiectpwj.dto.WorkContractDTO;
import com.dino14.proiectpwj.model.WorkContract;
import org.springframework.stereotype.Component;

@Component
public class WorkContractMapper {

    public WorkContract convertRequestToWorkContract(WorkContractDTO workContractDTO)
    {
        return new WorkContract(workContractDTO.getEmployee(),
                                workContractDTO.getCompany(),
                                workContractDTO.getNorm(),
                                workContractDTO.getType(),
                                workContractDTO.getDuration(),
                                workContractDTO.getSalary());
    }
}
