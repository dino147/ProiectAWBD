package com.dino14.proiectpwj.service;

import com.dino14.proiectpwj.model.BalanceSheet;
import com.dino14.proiectpwj.model.Company;
import com.dino14.proiectpwj.repository.BalanceSheetRepository;
import com.dino14.proiectpwj.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BalanceSheetService {

    private final BalanceSheetRepository balanceSheetRepository;

    private final CompanyRepository companyRepository;


    public BalanceSheetService(BalanceSheetRepository balanceSheetRepository, CompanyRepository companyRepository) {
        this.balanceSheetRepository = balanceSheetRepository;
        this.companyRepository = companyRepository;
    }

    public BalanceSheet saveBalanceSheet(BalanceSheet balanceSheet, Long companyId)
    {
        Optional<Company> companyOptional = companyRepository.findById(companyId);

        if(companyOptional.isEmpty())
            throw new RuntimeException("Invalid company id !");

        balanceSheet.setCompany(companyOptional.get());

        BalanceSheet savedBalanceSheet = balanceSheetRepository.save(balanceSheet);

        log.info("Saved balance sheet with id " + savedBalanceSheet.getBalanceSheetId()
                + " for company with id " + companyId);

        return savedBalanceSheet;
    }

    public List<BalanceSheet> retreiveAllBalanceSheets() {
        List<BalanceSheet> balanceSheetList = balanceSheetRepository.findAll();

        log.info("Retreived all balance sheets, size: " + balanceSheetList.size());
        return balanceSheetList;
    }

    public List<BalanceSheet> findBalanceSheetsByCompany(Long companyId)
    {
        Optional<Company> companyOptional = companyRepository.findById(companyId);

        if(companyOptional.isEmpty())
            throw new RuntimeException("Invalid company id !");

        List<BalanceSheet> balanceSheetList = balanceSheetRepository.findBalanceSheetsByCompany(companyOptional.get());

        log.info("Company with id " + companyId + " has " + balanceSheetList.size() + " balance sheets recorded !");

        return balanceSheetList;
    }

    public List<BalanceSheet> deleteBalanceSheetById(Long balanceSheetId)
    {
        balanceSheetRepository.deleteById(balanceSheetId);

        log.info("Deleted balance sheet with id " + balanceSheetId);

        return balanceSheetRepository.findAll();
    }
}
