package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
  Customer findById(int id);
  Customer findByName(String name);
  List<Customer>findByNameContainingIgnoreCase(String name);
  @Override
    List<Customer>findAll();
}
