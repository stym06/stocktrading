package com.navi.stocktrade.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Trade {
    private String buyId;
    private Double sellingPrice;
    private int quantity;
    private String sellId;
}
