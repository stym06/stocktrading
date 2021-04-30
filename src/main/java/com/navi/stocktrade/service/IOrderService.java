package com.navi.stocktrade.service;

import com.navi.stocktrade.models.Order;

public interface IOrderService {
    void placeOrder(Order order);
    void printDB();
}
