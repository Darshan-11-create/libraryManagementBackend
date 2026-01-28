package com.example.demo.books;

import com.example.demo.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
  Book findById(int id);
  List<Book> findByBookName(String name);
  List<Book>findByCustomer(Customer customer);
  List<Book>findByBookNameContainingIgnoreCase(String name);
}
