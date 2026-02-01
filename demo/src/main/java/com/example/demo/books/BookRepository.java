package com.example.demo.books;

import com.example.demo.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.LockModeType;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
@Lock(LockModeType.PESSIMISTIC_WRITE)
@Query("SELECT b FROM Book b WHERE b.id = :id")
  Book BuyOrRent(@Param("id") int id);
  Book findById(int id);
  List<Book> findByBookName(String name);
  List<Book>findByCustomer(Customer customer);
  List<Book>findByBookNameContainingIgnoreCase(String name);
}
