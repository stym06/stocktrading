package com.navi.stocktrade.service;

import com.navi.stocktrade.models.Order;
import com.navi.stocktrade.models.Trade;

public interface ITradeService {
    Trade trade(Order order);
}
