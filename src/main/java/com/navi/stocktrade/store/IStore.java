package com.navi.stocktrade.store;

import com.navi.stocktrade.models.BuyOrder;
import com.navi.stocktrade.models.SellOrder;
import com.navi.stocktrade.models.Trade;

import java.util.List;
import java.util.TreeSet;

public interface IStore {
    void createBuyOrder(BuyOrder buyOrder);
    void createSellOrder(SellOrder sellOrder);
    void removeBuyOrder(BuyOrder buyOrder);
    void removeSellOrder(SellOrder sellOrder);
    void print();
    TreeSet<BuyOrder> getBuyData();
    TreeSet<SellOrder> getSellData();
    void createTrade(Trade trade);
    List<Trade> getTradeData();
}
