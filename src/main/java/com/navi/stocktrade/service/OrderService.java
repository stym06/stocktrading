package com.navi.stocktrade.service;

import com.google.inject.Inject;
import com.navi.stocktrade.models.BuyOrder;
import com.navi.stocktrade.models.Order;
import com.navi.stocktrade.models.SellOrder;
import com.navi.stocktrade.store.IStore;
import com.navi.stocktrade.util.Constants;

public class OrderService implements IOrderService{

    @Inject
    private final IStore store;

    public OrderService(IStore store) {
        this.store = store;
    }

    @Override
    public void placeOrder(Order order) {
        if(order.getOrderType().equals(Constants.BUY)) {
            BuyOrder buyOrder = new BuyOrder(order.getId(), order.getTime(), order.getStock(), order.getPrice(), order.getQuantity());
            this.store.createBuyOrder(buyOrder);
        }
        else {
            SellOrder sellOrder = new SellOrder(order.getId(), order.getTime(), order.getStock(), order.getPrice(), order.getQuantity());
            this.store.createSellOrder(sellOrder);
        }
    }

    @Override
    public void printDB() {
        this.store.print();
    }

}
