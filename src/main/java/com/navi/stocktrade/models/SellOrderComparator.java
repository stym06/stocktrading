package com.navi.stocktrade.models;

import java.util.Comparator;

public class SellOrderComparator implements Comparator<SellOrder> {
    @Override
    public int compare(SellOrder s1, SellOrder s2) {
        return s1.getPrice().intValue() - s2.getPrice().intValue();
    }
}
