package com.navi.stocktrade.controller;

import com.navi.stocktrade.models.Order;
import com.navi.stocktrade.models.Trade;

public interface Controller {
    void run();
    Order parse(String[] tokens);
    void print(Trade trade);
}
