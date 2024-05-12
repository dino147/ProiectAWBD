package com.dino14.proiectpwj.controller;

import com.dino14.proiectpwj.dto.BalanceSheetDTO;
import com.dino14.proiectpwj.mapper.BalanceSheetMapper;
import com.dino14.proiectpwj.model.BalanceSheet;
import com.dino14.proiectpwj.service.BalanceSheetService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/balancesheet")
public class BalanceSheetController {

    public final BalanceSheetService balanceSheetService;

    public final BalanceSheetMapper balanceSheetMapper;

    public BalanceSheetController(BalanceSheetService balanceSheetService) {
        this.balanceSheetService = balanceSheetService;
        this.balanceSheetMapper = new BalanceSheetMapper();
    }

    @PostMapping("/new")
    public ResponseEntity<BalanceSheet> addNewBalanceSheet(@RequestBody @Valid BalanceSheetDTO balanceSheetDTO,
                                                           @RequestParam Long companyId) {

        BalanceSheet balanceSheet = balanceSheetService.saveBalanceSheet(
                                        balanceSheetMapper.convertRequestToBalanceSheet(balanceSheetDTO),
                                        companyId);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/balancesheet/{id}")
                .buildAndExpand(balanceSheet.getBalanceSheetId())
                .toUri();

        return ResponseEntity.created(location).body(balanceSheet);
    }

    @GetMapping("/list")
    public ResponseEntity<List<BalanceSheet>> listAllBalanceSheets() {
        return ResponseEntity.ok().body(balanceSheetService.retreiveAllBalanceSheets());
    }

    @GetMapping("/byCompany/{companyId}")
    public ResponseEntity<List<BalanceSheet>> getBalanceSheetsByCompanyName(@PathVariable Long companyId) {
        return ResponseEntity.ok().body(balanceSheetService.findBalanceSheetsByCompany(companyId));
    }

    @DeleteMapping("/remove/{balanceSheetId}")
    public ResponseEntity<List<BalanceSheet>> deleteBalanceSheet(@PathVariable Long balanceSheetId)
    {
        return ResponseEntity.ok().body(balanceSheetService.deleteBalanceSheetById(balanceSheetId));
    }
}
