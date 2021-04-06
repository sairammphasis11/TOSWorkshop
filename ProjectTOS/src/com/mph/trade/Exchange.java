package com.mph.trade;


//@Exchange interface
public interface Exchange {
    public String registerTrader(Trader trader);

    public void placeOrder(Order order);

    public void viewBook(long stockid);
}

