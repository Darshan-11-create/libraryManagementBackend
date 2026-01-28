package com.example.demo.books;

import java.util.List;

public interface BookService {
//    public boolean EnterBookDetails(Book book);
    public List<Book> AvailableBooks();
    public List<Book> SearchBooks(String name);
    public boolean purchaseBook(int id,int cust_id);
    public boolean RentBook(int id,int cust_id);
}
