package com.navi.stocktrade.controller;

import com.google.inject.Inject;
import com.navi.stocktrade.models.Order;
import com.navi.stocktrade.models.OrderType;
import com.navi.stocktrade.models.Trade;
import com.navi.stocktrade.service.IOrderService;
import com.navi.stocktrade.service.ITradeService;
import com.navi.stocktrade.service.OrderService;
import com.navi.stocktrade.service.TradeService;
import com.navi.stocktrade.store.IStore;
import com.navi.stocktrade.util.Constants;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Slf4j
public class InputController implements Controller{

    @Inject
    private final IOrderService orderService;
    @Inject
    private final ITradeService tradeService;

    public InputController(IStore store) {
        this.orderService = new OrderService(store);
        this.tradeService = new TradeService(store);
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                Order order = this.parse(tokens);
                this.orderService.placeOrder(order);

                this.orderService.printDB();
                log.info("--------");

                //attempt a new trade
                List<Trade> trades = this.tradeService.trade();
                trades.sort(new Comparator<Trade>() {
                    @Override
                    public int compare(Trade o1, Trade o2) {
                        String id1 = o1.getBuyId();
                        String id2 = o2.getBuyId();
                        return Integer.parseInt(String.valueOf(id1.charAt(1))) - Integer.parseInt(String.valueOf(id2.charAt(1)));
                    }
                });
                for(Trade trade: trades) {
                   log.info("{}",trade);
                }
            }

            //clear remaning trades
            this.orderService.printDB();
            this.tradeService.completeRemainingTrades();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order parse(String[] tokens) {
        Order order = Order.builder().
                id(tokens[0]).
                time(tokens[1]).
                stock(tokens[2]).
                orderType(getOrderType(tokens[3])).
                price(Double.parseDouble(tokens[4])).
                quantity(Integer.parseInt(tokens[5])).
                build();

        return order;
    }

    @Override
    public void print(Trade trade) {
        System.out.println(trade.toString());
    }

    private String getOrderType(String s) {
        return s.equalsIgnoreCase("buy") ? Constants.BUY : Constants.SELL;
    }
}
