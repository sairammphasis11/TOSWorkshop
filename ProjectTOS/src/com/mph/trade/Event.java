package com.mph.trade;


//@Event class to get the Order details ( NEW , CANCEL)
public class Event {

    private Order order;
    private OrderRequestType requestType;


    public Event(Order order, OrderRequestType requestType) {
        this.order = order;
        this.requestType = requestType;
    }

    public Event() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderRequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(OrderRequestType requestType) {
        this.requestType = requestType;
    }

}


