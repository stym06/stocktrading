package com.navi.stocktrade.service;

import com.navi.stocktrade.models.Order;
import com.navi.stocktrade.models.Trade;

import java.util.List;

public interface ITradeService {
    List<Trade> trade();
    List<Trade> completeRemainingTrades();
}
