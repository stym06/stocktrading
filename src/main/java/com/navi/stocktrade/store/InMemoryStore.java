package com.navi.stocktrade.store;

import com.navi.stocktrade.models.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Slf4j
public class InMemoryStore implements IStore{

    public TreeSet<BuyOrder> buyOrderTreeSet;
    public TreeSet<SellOrder> sellOrderTreeSet;
    public List<Trade> tradeStore;

    public InMemoryStore() {
        this.buyOrderTreeSet = new TreeSet<>(new BuyOrderComparator());
        this.sellOrderTreeSet = new TreeSet<>(new SellOrderComparator());
        this.tradeStore = new ArrayList<>();
    }

    @Override
    public void createBuyOrder(BuyOrder buyOrder) {
        buyOrderTreeSet.add(buyOrder);
    }

    @Override
    public void print() {
        for(BuyOrder buyOrder: buyOrderTreeSet) {
            log.info("{}",buyOrder);
        }
        for(SellOrder sellOrder: sellOrderTreeSet) {
            log.info("{}",sellOrder);
        }
    }

    @Override
    public TreeSet<BuyOrder> getBuyData() {
        return this.buyOrderTreeSet;
    }

    @Override
    public TreeSet<SellOrder> getSellData() {
        return this.sellOrderTreeSet;
    }

    @Override
    public void createTrade(Trade trade) {
        this.tradeStore.add(trade);
    }

    @Override
    public List<Trade> getTradeData() {
        return this.tradeStore;
    }

    @Override
    public void createSellOrder(SellOrder sellOrder) {
        this.sellOrderTreeSet.add(sellOrder);
    }

    @Override
    public void removeBuyOrder(BuyOrder buyOrder) {
        this.buyOrderTreeSet.remove(buyOrder);
    }

    @Override
    public void removeSellOrder(SellOrder sellOrder) {
        this.sellOrderTreeSet.remove(sellOrder);
    }
}
