package com.example.demo.user;

import com.example.demo.books.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 private String name;
 private String phno;
 private String email;
private String gender;
private String password;
private int totalbooksbought;
private int totalbooksrent;
private int totalRentPrice;
private int totalprice;
    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<Book> books;

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotalRentPrice() {
        return totalRentPrice;
    }

    public void setTotalRentPrice(int totalRentPrice) {
        this.totalRentPrice = totalRentPrice;
    }
}
