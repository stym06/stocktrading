package com.navi.stocktrade.service;

import com.navi.stocktrade.models.BuyOrder;
import com.navi.stocktrade.models.Order;
import com.navi.stocktrade.models.SellOrder;
import com.navi.stocktrade.models.Trade;
import com.navi.stocktrade.store.IStore;
import com.navi.stocktrade.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TradeService implements ITradeService{

    private final IStore store;

    public TradeService(IStore store) {
        this.store = store;
    }

    @Override
    public List<Trade> trade() {
        List<Trade> tradeList = new ArrayList<>();
        TreeSet<SellOrder> sellOrders = this.store.getSellData();
        TreeSet<BuyOrder> buyOrders = this.store.getBuyData();

        if(buyOrders.isEmpty() || sellOrders.isEmpty())  return tradeList;

        for(BuyOrder buyOrder: buyOrders) {
            if(buyOrder.getQuantity() == 0) continue;
            boolean traded = false;
            for(SellOrder sellOrder: sellOrders) {
                //move on if diff stock
                if(!sellOrder.getStock().equalsIgnoreCase(buyOrder.getStock()) || sellOrder.getQuantity() == 0 || sellOrder.getPrice() > buyOrder.getPrice()) continue;

                int tradedQuantity = 0;
                if(sellOrder.getQuantity() < buyOrder.getQuantity()) {
                    tradedQuantity = sellOrder.getQuantity();
                    sellOrder.setQuantity(0);
                    buyOrder.setQuantity(buyOrder.getQuantity() - tradedQuantity);
                }

                Trade trade = new Trade(buyOrder.getId(), sellOrder.getPrice(), tradedQuantity, sellOrder.getId());
                tradeList.add(trade);
                this.store.createTrade(trade);
                traded = true;
                break;
            }

            if(traded) break;

        }

        return tradeList;
    }

    @Override
    public List<Trade> completeRemainingTrades() {
        List<Trade> tradeList = new ArrayList<>();
        return tradeList;
    }
}
