package com.alexcojocaru.proiectpwj.mapper;

import com.alexcojocaru.proiectpwj.dto.BalanceSheetDTO;
import com.alexcojocaru.proiectpwj.model.BalanceSheet;
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
