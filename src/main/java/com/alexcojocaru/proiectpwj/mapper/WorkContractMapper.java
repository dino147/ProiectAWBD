package com.alexcojocaru.proiectpwj.mapper;

import com.alexcojocaru.proiectpwj.dto.WorkContractDTO;
import com.alexcojocaru.proiectpwj.model.WorkContract;
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
