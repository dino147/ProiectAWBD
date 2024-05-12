package com.dino14.proiectpwj.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

// @Data has the same effect as adding @EqualsAndHashCodes, @Getter, @Setter, @ToString.
// It also adds a constructor that takes as arguments all @NonNull and final fields. Try "Refactor – Delombok" to see the equivalent Java Code.
@Data
@Entity
public class BalanceSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long balanceSheetId;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private double revenue;

    private double profit;

    private double cashFlow;

    private double fixedAssets;

    private Date date;

    public BalanceSheet() {
    }

    public BalanceSheet(Company company, double revenue, double profit, double cashFlow, double fixedAssets, Date date) {
        this.company = company;
        this.revenue = revenue;
        this.profit = profit;
        this.cashFlow = cashFlow;
        this.fixedAssets = fixedAssets;
        this.date = date;
    }

//
//    public BalanceSheet(long balanceSheetId, Company company, double revenue, double profit, double cashFlow, double fixedAssets) {
//        this.balanceSheetId = balanceSheetId;
//        this.company = company;
//        this.revenue = revenue;
//        this.profit = profit;
//        this.cashFlow = cashFlow;
//        this.fixedAssets = fixedAssets;
//    }
//
//
//    public long getBalanceSheetId() {
//        return balanceSheetId;
//    }
//
//    public void setBalanceSheetId(long balanceSheetId) {
//        this.balanceSheetId = balanceSheetId;
//    }
//
//    public Company getCompany() {
//        return company;
//    }
//
//    public void setCompany(Company company) {
//        this.company = company;
//    }
//
//    public double getRevenue() {
//        return revenue;
//    }
//
//    public void setRevenue(double revenue) {
//        this.revenue = revenue;
//    }
//
//    public double getProfit() {
//        return profit;
//    }
//
//    public void setProfit(double profit) {
//        this.profit = profit;
//    }
//
//    public double getCashFlow() {
//        return cashFlow;
//    }
//
//    public void setCashFlow(double cashFlow) {
//        this.cashFlow = cashFlow;
//    }
//
//    public double getFixedAssets() {
//        return fixedAssets;
//    }
//
//    public void setFixedAssets(double fixedAssets) {
//        this.fixedAssets = fixedAssets;
//    }
}
