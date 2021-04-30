package com.navi.stocktrade.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BuyOrder {
    private String id;
    private String time;
    private String stock;
    private Double price;
    private int quantity;
}