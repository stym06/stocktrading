package com.navi.stocktrade.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class BuyOrderComparator implements Comparator<BuyOrder> {

    @Override
    public int compare(BuyOrder b1, BuyOrder b2) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date d1 = sdf.parse(b1.getTime());
            Date d2 = sdf.parse(b2.getTime());

            return (int) (d2.getTime() - d1.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
