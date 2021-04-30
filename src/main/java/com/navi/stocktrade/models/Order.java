package com.navi.stocktrade.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private String id;
    private String time;
    private String stock;
    private String orderType;
    private Double price;
    private int quantity;
}

