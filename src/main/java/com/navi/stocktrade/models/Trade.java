package com.navi.stocktrade.models;

import lombok.Data;

@Data
public class Trade {
    private String buyId;
    private Double sellingPrice;
    private int quantity;
    private String sellId;
}
