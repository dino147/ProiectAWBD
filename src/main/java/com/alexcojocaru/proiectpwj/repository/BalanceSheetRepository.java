package com.alexcojocaru.proiectpwj.repository;

import com.alexcojocaru.proiectpwj.model.BalanceSheet;
import com.alexcojocaru.proiectpwj.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BalanceSheetRepository extends JpaRepository<BalanceSheet, Long> {

    public List<BalanceSheet> findBalanceSheetsByCompany(Company company);
}
