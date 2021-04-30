package com.navi.stocktrade;

import com.navi.stocktrade.controller.Controller;
import com.navi.stocktrade.controller.InputController;
import com.navi.stocktrade.store.IStore;
import com.navi.stocktrade.store.InMemoryStore;

public class Driver {
    public static void main(String[] args) {
        IStore store = new InMemoryStore();

        Controller controller = new InputController(store);
        controller.run();

    }
}
