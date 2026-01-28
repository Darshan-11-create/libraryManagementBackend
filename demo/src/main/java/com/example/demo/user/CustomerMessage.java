package com.example.demo.user;

import java.util.List;

public class CustomerMessage {
    private String action;
    private Customer customer;
    public CustomerMessage(String action,Customer customer){
        this.action=action;
        this.customer=customer;
    }

    public String getAction() {
        return action;
    }

    public Customer getCustomer() {
        return customer;
    }


}
