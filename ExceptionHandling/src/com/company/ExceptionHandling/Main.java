package com.company.ExceptionHandling;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Logger logger = Logger.getLogger(Main.class.getName());

        ExHndlr eh = new ExHndlr();
        try {
            eh.test(true);
        } catch (CustomExcep customExcep) {
            customExcep.printStackTrace();
        }
        logger.log(Level.SEVERE,"Loger END");

    }
}

class CustomExcep extends Exception{

    @Override
    public String getMessage() {
        return "Created Custom Exception";
    }
}

class ExHndlr{

    void test(boolean bool) throws CustomExcep {
    if(bool){
        throw new CustomExcep();
    }


   }
    void test1() throws ClassNotFoundException {
        Class.forName("java.util.Dae");
    }

}
