package com.navi.stocktrade.service;

import com.navi.stocktrade.models.BuyOrder;
import com.navi.stocktrade.models.Order;
import com.navi.stocktrade.models.SellOrder;
import com.navi.stocktrade.models.Trade;
import com.navi.stocktrade.store.IStore;
import com.navi.stocktrade.util.Constants;

import java.util.TreeSet;

public class TradeService implements ITradeService{

    private final IStore store;

    public TradeService(IStore store) {
        this.store = store;
    }

    @Override
    public Trade trade(Order order) {
        if(order.getOrderType().equals(Constants.BUY)) {
            BuyOrder buyOrder = new BuyOrder(order.getId(), order.getTime(), order.getStock(), order.getPrice(), order.getQuantity());
            return matchBuyOrder(buyOrder);
        }
        else {
            SellOrder sellOrder = new SellOrder(order.getId(), order.getTime(), order.getStock(), order.getPrice(), order.getQuantity());
            return matchSellOrder(sellOrder);
        }
    }

    private Trade matchSellOrder(SellOrder sellOrder) {
        TreeSet<BuyOrder> buyOrders = this.store.getBuyData();
        if(buyOrders.isEmpty()) {
            this.store.createSellOrder(sellOrder);
        }

        buyOrders.first()

        for(BuyOrder buyOrder: buyOrders) {
            if(sellOrder.getStock().equalsIgnoreCase(buyOrder.getStock()) && sellOrder.getQuantity() > buyOrder.getQuantity()) {
                this.store.createSellOrder(sellOrder);
            }
        }
    }

    private Trade matchBuyOrder(BuyOrder buyOrder) {
    }
}
