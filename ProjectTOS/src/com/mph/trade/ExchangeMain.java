package com.mph.trade;


import com.mph.book.BuySell;
import com.mph.book.XchangeWorker;


import java.io.IOException;
import java.util.logging.Logger;


public class ExchangeMain {
    private static final Logger logger = Logger.getLogger(ExchangeMain.class.getName());

    public static void main(String[] args) throws IOException {

        MiniExchange ex = new MiniExchange();
        String result = ex.registerTrader(new Trader("priya", "97898", "addr1"));
        String result2 = ex.registerTrader(new Trader("ajay", "97910", "addr2"));
        ex.registerTrader(new Trader("puja", "1234", "addr3"));

        logger.info(result);
        logger.info(result2);
        logger.info("" + ex.getAllTraders());
        logger.info("" + ex.updateTrader(new Trader("priya", "8765", "addr2", "97898")));
        ex.placeOrder(new Order("3472", "14", 13, 4, 2, BuySell.SELL));


    }

}
