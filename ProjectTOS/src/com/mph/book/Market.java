package com.mph.book;

import com.mph.trade.Event;
import com.mph.trade.MiniExchange;
import com.mph.trade.Order;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;


//@Market Class to trade the order (Order Matching)
public class Market {


    private static final Logger LOGGER = Logger.getLogger(Market.class.getName());

    private List<Order> orderList = new ArrayList<Order>();


    public Market() {

    }

    //performs buy and sell order matching for particular stock ID
    public synchronized void execute() {

        this.orderList = MiniExchange.getAllOrders();

        System.out.println("List size from market " + MiniExchange.getAllOrders().size());

        this.orderList
                .stream().filter(o -> o.getSide().equals(BuySell.SELL))
                .forEach(
                        product -> {

                            LOGGER.info("trading stock " + product.stockId); //123
                            List<Order> buyOrderForStock = getBuyOrdersForStock(product.getStockId());
                            if (buyOrderForStock.size() == 0) {
                                LOGGER.info("no buyers interested in stock "
                                        + product.stockId
                                );
                            } else {

                                Optional<Order> tradedOrder = buyOrderForStock.stream().filter(
                                        ord -> {
                                            return ord.getQty() <= product.getQty();

                                        }
                                ).sorted(Comparator.comparingLong(Order::getPrice)).findFirst();

                                System.out.println("traded order " + tradedOrder);
                                if (!tradedOrder.isPresent()) {
                                    System.out.println("no trade happened");
                                } else {
                                    LOGGER.info("traded buy order " + tradedOrder.get());
                                    String BuyOrderId = tradedOrder.get().orderId;
                                    String sellerOrderId = product.orderId;
                                    product.setQty(product.getQty() - tradedOrder.get().qty);
                                    if (product.getQty() == 0) {
                                        MiniExchange.deleteOrder(sellerOrderId);
                                    }
                                    System.out.println("product sell order " + product);
                                    MiniExchange.deleteOrder(BuyOrderId);

                                    LOGGER.info("traded order removed from orderList");

                                }
                            }
                        });


        System.out.println("executed");

    }

    //Retrieves the buy orders for a particular stock ID
    public List<Order> getBuyOrdersForStock(long stockId) {

        return this.orderList.stream().filter(e -> {

            return ((e.getStockId() == stockId) && e.getSide().equals(BuySell.BUY));

        }).collect(Collectors.toList());
    }


    public long cancel(Event event) {
        //TODO
        return 1l;
    }


    public void modify(Event event) {
        //TODO
    }

    //deletes the order based on specified order ID
    public void delete(String orderId) {
        MiniExchange.deleteOrder(orderId);
    }


}
