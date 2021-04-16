package com.mphasis.SpringBoot;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements  MessageService{
    @Override
    public void sendMessage() {
        System.out.println("in Email Service Send Message method");
    }
}
