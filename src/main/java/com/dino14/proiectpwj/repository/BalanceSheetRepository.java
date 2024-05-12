package com.dino14.proiectpwj.repository;

import com.dino14.proiectpwj.model.BalanceSheet;
import com.dino14.proiectpwj.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BalanceSheetRepository extends JpaRepository<BalanceSheet, Long> {

    public List<BalanceSheet> findBalanceSheetsByCompany(Company company);
}
