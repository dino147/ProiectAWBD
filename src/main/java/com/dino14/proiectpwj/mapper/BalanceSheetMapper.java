package com.dino14.proiectpwj.mapper;

import com.dino14.proiectpwj.dto.BalanceSheetDTO;
import com.dino14.proiectpwj.model.BalanceSheet;
import org.springframework.stereotype.Component;

@Component
public class BalanceSheetMapper {

    public BalanceSheet convertRequestToBalanceSheet(BalanceSheetDTO balanceSheetDTO)
    {
        return new BalanceSheet(balanceSheetDTO.getCompany(),
                                balanceSheetDTO.getRevenue(),
                                balanceSheetDTO.getProfit(),
                                balanceSheetDTO.getCashFlow(),
                                balanceSheetDTO.getFixedAssets(),
                                balanceSheetDTO.getDate());
    }
}
