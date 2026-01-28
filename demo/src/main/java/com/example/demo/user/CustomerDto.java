package com.example.demo.user;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class CustomerDto {
    private  int id;
   private String name;
   private String email;
   private String phno;
   private int totalbooksbought;
    private int totalbooksrent;
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public int getTotalbooksbought() {
        return totalbooksbought;
    }

    public void setTotalbooksbought(int totalbooksbought) {
        this.totalbooksbought = totalbooksbought;
    }

    public int getTotalbooksrent() {
        return totalbooksrent;
    }

    public void setTotalbooksrent(int totalbooksrent) {
        this.totalbooksrent = totalbooksrent;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
