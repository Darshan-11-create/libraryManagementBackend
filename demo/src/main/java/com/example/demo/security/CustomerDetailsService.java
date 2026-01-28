package com.example.demo.security;

import com.example.demo.user.Customer;
import com.example.demo.user.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsService implements UserDetailsService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Customer c=customerRepository.findByName(username);
          Customer  c=customerRepository.findByName(username);
        return new CustomerService(c.getName(),c.getPassword());
    }
}
