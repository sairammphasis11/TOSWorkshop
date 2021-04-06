package com.mph.book;


import com.mph.trade.Event;
import com.mph.trade.OrderRequestType;

import java.util.logging.Logger;

//@Xchangeworker will perform the task by taking run method
public class XchangeWorker implements Runnable {


    private static final Logger logger = Logger.getLogger(XchangeWorker.class.getName());
    private Market market = new Market();
    private Event event;

    public XchangeWorker(Event event) {
        this.event = event;
    }

    public XchangeWorker(Market market, Event event) {
        this.market = market;
        this.event = event;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "XchangeWorker{" +
                "market=" + market +
                ", event=" + event +
                '}';
    }


    //performs operations based on the order type
    @Override
    public void run() {
        if (event.getRequestType() == OrderRequestType.NEW) {
            market.execute();
        } else if (event.getRequestType() == OrderRequestType.CANCEL) {
            market.cancel(event);
        } else if (event.getRequestType() == OrderRequestType.MODIFY) {
            market.modify(event);
        } else {
            logger.info("Invalid Request Type");
            try {
                throw new InvalidTraderException("Invalid Request Type");
            } catch (InvalidTraderException e) {
                e.printStackTrace();
            }
        }


    }
}

