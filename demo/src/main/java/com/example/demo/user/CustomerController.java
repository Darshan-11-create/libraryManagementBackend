package com.example.demo.user;

import com.example.demo.mailService.emailService;
import com.example.demo.security.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@Repository
public class CustomerController implements CustomerServices {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private emailService emailService;
    @PostMapping("/Registration")
    public boolean EnterDetails(@RequestBody Customer customer){
        try {
            Customer c=customerRepository.findByName(customer.getName());
            if(c!=null)
                 return false;
            customerRepository.save(customer);
            c=customer;
            emailService.sendMail(c.getEmail(),"Registration Confirmed", customer.getName()+" Your Registration Confirmed");
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
     return true;
  }
  @GetMapping("/CustomerDetails")
    public Customer details(@RequestParam String name){
        Customer c=customerRepository.findByName(name);
        return c;
  }
}
