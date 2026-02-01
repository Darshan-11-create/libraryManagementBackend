package com.example.demo.books;

import com.example.demo.mailService.emailService;
import com.example.demo.user.Customer;
import com.example.demo.user.CustomerRepository;
import com.example.demo.webSocket.SocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
public class BookController implements BookService{
    @Autowired
    private emailService emailService;
    @Autowired
     private SocketService socketService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/AvailableBooks")
    public List<Book> AvailableBooks(){
        return bookRepository.findAll();
    }
    @GetMapping("/SearchBooks")
    public List<Book> SearchBooks(@RequestParam String name){
        return bookRepository.findByBookNameContainingIgnoreCase(name);
    }
    @Transactional
    @PostMapping("/PurchaseBook")
    public boolean purchaseBook(@RequestParam int id,@RequestParam int cust_id){
         Book b1=bookRepository.findById(id);
        Customer c=customerRepository.findById(cust_id);
//        Book pbook=null;
        try{

                    if (!b1.isRented() && !b1.isBought()) {
                         int total=c.getTotalbooksbought();
                         c.setTotalbooksbought(total+1);
                         int price=c.getTotalprice();
                         c.setTotalprice(price+b1.getPrice());
                         b1.setCustomer(c);
                          b1.setTaken(LocalDate.now());
                         customerRepository.save(c);
                         b1.setBought(true);
                        bookRepository.save(b1);
                        socketService.notifyBookRent("Bought",b1);
                    }
                    else {
                        return false;
                    }
        } catch (Exception e) {
            return false;
        }
        emailService.sendMail(c.getEmail(), "Purchase Book",b1.toString());
        return true;
    }
    @Transactional
    @PostMapping("/RentBook")
    public boolean RentBook(@RequestParam int id,@RequestParam int cust_id){
        Customer c=customerRepository.findById(cust_id);
       Book b1=bookRepository.findById(id);
        Book pbook=null;
        try{

                    if (!b1.isRented() && !b1.isBought()) {
                        b1.setRented(true);
                        LocalDate date=LocalDate.now();
                        b1.setTaken(date);
                        int total=c.getTotalbooksrent();
                        c.setTotalbooksrent(total+1);
//                        int rentPrice=c.getTotalprice();
//                        c.setTotalprice( b1.getRentPrice());
                        b1.setCustomer(c);
                        c.getBooks().add(b1);
                        c.setBooks(c.getBooks());
                        customerRepository.save(c);
                        bookRepository.save(b1);
                        pbook=b1;
                        socketService.notifyBookRent("Rent",b1);
                    }
                    else{
                        return false;
                    }
        } catch (Exception e) {
            return false;
        }
        emailService.sendMail(c.getEmail(), "Rented Book",pbook.toString());
        return true;
    }
}
