package com.example.demo.Manager;

import com.example.demo.books.Book;

public interface ManagerServices {
 public boolean RemoveCustomer(int id);
 public boolean RemoveBook(int id);
 public boolean RemoveBook(String name);
 public boolean AddBook(Book book);
}
