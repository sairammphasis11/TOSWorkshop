package com.mph.trade;


import com.mph.book.*;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

//@MiniExchange class used for Trader registration and to place order
public class MiniExchange implements Exchange {

    private static final Logger logger = Logger.getLogger(MiniExchange.class.getName());

    private Map<String, Trader> trader = new HashMap<>();
    public static Map<String, Order> orderMap = new HashMap<>();
    private long traderid = 100;
    private long orderId = 100;
    private Market market;
    ExecutorService executor = null;

    public MiniExchange() {
        trader.put("9792", new Trader("raji", "978", "addr1", "9792"));
        trader.put("3262", new Trader("ajay", "325", "addr 2", "3262"));
        trader.put("3472", new Trader("puja", "346", "addr3", "3472"));

        orderMap.put("11", new Order("97899T", "11", 12, 2, 4, BuySell.SELL));
        orderMap.put("12", new Order("9678T", "12", 3, 3, 3, BuySell.BUY));
        orderMap.put("13", new Order("96574T", "13", 3, 3, 3, BuySell.SELL));
        market = new Market();
    }

    //validates the trader before order is placed
    public String validate(Order order) throws InvalidTraderException {
        String value = getValidTrader(order.getTraderId());
        return value;
    }

    //performs new trader registration
    @Override
    public String registerTrader(Trader traders) {
        traderid = 1 + Integer.valueOf(traders.getContactno());
        traders.setTraderid(traderid + "2");
        trader.put(traderid + "2", traders);
        logger.info(traderid + "2");
        return traderid + "2";
    }

    //updates the trader details
    public Trader updateTrader(Trader traders) {
        if (traders.getTraderid() == null) {
            return null;
        }
        trader.put(traders.getTraderid(), traders);
        return traders;
    }

    //deletes the trader based on trader ID
    public Trader deleteTrade(String traderid) {

        return trader.remove(traderid);

    }

    //Retrieves all the traders
    public List<Trader> getAllTraders() {

        return new ArrayList<Trader>(trader.values());
    }

    //validates the trader based on the trader ID. If not a valid trader, it throws the custom exception
    public String getValidTrader(String Traderid) throws InvalidTraderException {
        String msg = "";
        if (trader.get(Traderid) == null) {
            msg = "Invalid Trader";
            throw new InvalidTraderException(msg);
        } else if (trader.get(Traderid).getTraderid().equals(Traderid)) {
            msg = "Valid Trader";
            return msg;
        } else {
            try {
                msg = "Invalid Trader";
                throw new InvalidTraderException(msg);
            } catch (InvalidTraderException e) {
                e.printStackTrace();
            }
        }
        msg = "Invalid Trader";
        return msg;
    }

    //Retrieves the trader based on trader ID
    public Trader getTrader(String Traderid) {
        return trader.get(Traderid);
    }

    //places the new order and executes the task in run method of XchangeWorker Class
    @Override
    public void placeOrder(Order order) {
        String validTrader = " ";
        try {
            validTrader = validate(order);
        } catch (InvalidTraderException e) {
            e.printStackTrace();
        }

        if (validTrader.equalsIgnoreCase("valid trader")) {
            orderId = 1 + Integer.parseInt(order.getTraderId());
            order.setOrderId(orderId + "O");
            orderMap.put(orderId + "O", order);
            logger.info("Order Id: " + orderId + "O");
            logger.info("Event");
            Event event = new Event();
            event.setRequestType(OrderRequestType.NEW);
            logger.info("Thread started");
            int coreCount = Runtime.getRuntime().availableProcessors();
            logger.info(coreCount + "");
            executor = Executors.newFixedThreadPool(coreCount);

            Runnable worker = new XchangeWorker(event);
            executor.execute(worker);


            executor.shutdown();
            logger.info("Finished all threads");
        }

    }

    //retrieves all the orders
    public static List<Order> getAllOrders() {

        return new ArrayList<Order>(orderMap.values());
    }

    //deletes the order based on order ID
    public static void deleteOrder(String orderId) {

        orderMap.remove(orderId);
        System.out.println("order list after trade" + orderMap);

    }

    //retrieves order based on stock id
    @Override
    public void viewBook(long stockid) {
        logger.info("" + orderMap.get(stockid));
    }

}
