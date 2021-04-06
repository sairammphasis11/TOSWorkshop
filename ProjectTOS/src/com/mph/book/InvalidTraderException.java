package com.mph.book;

//@InvalidTrader Exception class for handling the class level exception
public class InvalidTraderException extends Exception {

    public InvalidTraderException(String message) {
        super(message);
    }

    public InvalidTraderException() {
        super();
    }

}
