package com.navi.stocktrade.store;

import com.navi.stocktrade.models.BuyOrder;
import com.navi.stocktrade.models.BuyOrderComparator;
import com.navi.stocktrade.models.SellOrder;
import com.navi.stocktrade.models.SellOrderComparator;

import java.util.TreeSet;

public class InMemoryStore implements IStore{

    public TreeSet<BuyOrder> buyOrderTreeSet;
    public TreeSet<SellOrder> sellOrderTreeSet;

    public InMemoryStore() {
        this.buyOrderTreeSet = new TreeSet<>(new BuyOrderComparator());
        this.sellOrderTreeSet = new TreeSet<>(new SellOrderComparator());
    }

    @Override
    public void createBuyOrder(BuyOrder buyOrder) {
        buyOrderTreeSet.add(buyOrder);
    }

    @Override
    public void print() {
        for(BuyOrder buyOrder: buyOrderTreeSet) {
            System.out.printf(buyOrder.getTime()+"\n");
        }
        for(SellOrder sellOrder: sellOrderTreeSet) {
            System.out.printf(sellOrder.getPrice()+"\n");
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
