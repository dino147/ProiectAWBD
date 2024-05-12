package com.alexcojocaru.proiectpwj.controller;

import com.alexcojocaru.proiectpwj.dto.WorkContractDTO;
import com.alexcojocaru.proiectpwj.mapper.WorkContractMapper;
import com.alexcojocaru.proiectpwj.model.WorkContract;
import com.alexcojocaru.proiectpwj.service.WorkContractService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/workcontract")
public class WorkContractController {

    public final WorkContractService workContractService;

    public final WorkContractMapper workContractMapper;

    public WorkContractController(WorkContractService workContractService) {
        this.workContractService = workContractService;
        this.workContractMapper = new WorkContractMapper();
    }

    @PostMapping("/new")
    public ResponseEntity<WorkContract> addNewWorkContract(@RequestBody @Valid WorkContractDTO workContractDTO,
                                                           @RequestParam Long employeeId, @RequestParam Long companyId)
    {
        WorkContract workContract = workContractService.saveWorkContract(
                                                        workContractMapper.convertRequestToWorkContract(workContractDTO),
                                                        employeeId, companyId);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/workcontract/{id}")
                .buildAndExpand(workContract.getWorkContractId())
                .toUri();

        return ResponseEntity.created(location).body(workContract);
    }

    @GetMapping("/list")
    public ResponseEntity<List<WorkContract>> listAllWorkContracts() {
        return ResponseEntity.ok().body(workContractService.retrieveAllContracts());
    }

    @DeleteMapping("/remove/{workContractId}")
    public ResponseEntity<List<WorkContract>> deleteWorkContract(@PathVariable Long workContractId) {
        return ResponseEntity.ok().body(workContractService.deleteWorkContractById(workContractId));
    }

    @GetMapping("/byEmployee/{firstName}&{lastName}")
    public ResponseEntity<List<WorkContract>> retreiveWorkContractsByEmployeeName(@PathVariable String firstName, @PathVariable String lastName)
    {
        return ResponseEntity.ok().body(workContractService.findWorkContractsByEmployeeName(firstName, lastName));
    }
}
