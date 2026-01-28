package com.example.demo.books;

import com.example.demo.user.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
    @Column(nullable=false)
   private String bookName;
    @Column(nullable=false)
  private String bookAuthorName;
  private int price;
  private int RentPrice;
  private boolean Rented=false;
  private boolean bought=false;
  private LocalDate Taken=null;
  private LocalDate Returned=null;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;   // 🔥 MUST be named 'customer'

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthorName() {
        return bookAuthorName;
    }

    public void setBookAuthorName(String bookAuthorName) {
        this.bookAuthorName = bookAuthorName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRentPrice() {
        return RentPrice;
    }

    public void setRentPrice(int rentPrice) {
        RentPrice = rentPrice;
    }

    public boolean isRented() {
        return Rented;
    }

    public void setRented(boolean rented) {
        Rented = rented;
    }

    public LocalDate getTaken() {
        return Taken;
    }

    public void setTaken(LocalDate taken) {
        Taken = taken;
    }

    public LocalDate getReturned() {
        return Returned;
    }

    public void setReturned(LocalDate returned) {
        Returned = returned;
    }

    @Override
    public String toString() {
        return "Book Details:\n" +
                "ID: " + id + "\n" +
                "Name: " + bookName + "\n" +
                "Author: " + bookAuthorName + "\n" +
                "Price: " + price + "\n" +
                "Rented: " + Rented + "\n" +
                "Bought: " + bought;
    }
}
