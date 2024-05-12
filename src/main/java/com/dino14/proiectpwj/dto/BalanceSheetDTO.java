package com.dino14.proiectpwj.dto;

import com.dino14.proiectpwj.model.Company;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BalanceSheetDTO {

    private Company company;

    @Min(message = "Revenue must be positive !", value = 0)
    private double revenue;

    private double profit;

    private double cashFlow;

    @Min(message = "Fixed assets must be positive !", value = 0)
    private double fixedAssets;

    private Date date;

//    public BalanceSheetRequest() {
//    }
//
//    public BalanceSheetRequest(Company company, double revenue, double profit, double cashFlow, double fixedAssets) {
//        this.company = company;
//        this.revenue = revenue;
//        this.profit = profit;
//        this.cashFlow = cashFlow;
//        this.fixedAssets = fixedAssets;
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
