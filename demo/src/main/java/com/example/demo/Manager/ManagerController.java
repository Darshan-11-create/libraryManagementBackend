package com.example.demo.Manager;

import com.example.demo.books.Book;
import com.example.demo.books.BookRepository;
import com.example.demo.mailService.emailService;
import com.example.demo.user.Customer;
import com.example.demo.user.CustomerRepository;
import com.example.demo.webSocket.SocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private emailService emailService;
  @Autowired
    private CustomerRepository customerRepository;
  @Autowired
    private BookRepository bookRepository;
  @Autowired
   private SocketService socketService;
  @PostMapping("/RemoveTheCustomer")
    public boolean RemoveTheCustomer(@RequestParam int id){
      try {

          Customer c = customerRepository.findById(id);
          List<Book> b=bookRepository.findByCustomer(c);
          for(Book b1:b){
              b1.setCustomer(null);
              bookRepository.save(b1);
          }
          emailService.sendMail(c.getEmail(),"Sorry You have been Removed From accessing Our Books","Please Consult library manager for more details");
          socketService.customerRemover("Remove",c);
//          socketService.customerRemover("");
          customerRepository.delete(c);
      } catch (Exception e) {
//          throw new RuntimeException(e);
          return false;
      }
      return true;
  }
  @GetMapping("/CheckDetails")
  public Customer getCustomer(@RequestParam int id){
       return customerRepository.findById(id);
  }
    @PostMapping("/RemoveBook")
    public boolean RemoveBook(@RequestParam int id){
        try {
            Book c = bookRepository.findById(id);
            List<Customer>custAll=allcustomers();
            for(int i=0;i<custAll.size();i++){
                emailService.sendMail(custAll.get(i).getEmail(),"This Book Has Been Removed",c.toString());
            }
            socketService.notifyBookRent("Remove",c);
            bookRepository.delete(c);

        } catch (Exception e) {
//          throw new RuntimeException(e);
            return false;
        }
        return true;
    }
    @PostMapping("/AddBook")
    public boolean AddBook(@RequestBody Book book){
      List<Customer>all=customerRepository.findAll();
      try{
          bookRepository.save(book);
          socketService.notifyBookRent("NewBook",book);
          for(int i=0;i<all.size();i++){
              emailService.sendMail(all.get(i).getEmail()+"","New Book Added",book.toString());
          }
      } catch (Exception e) {
          return false;
      }
      return true;
    }
    @GetMapping("/AllCustomers")
    public List<Customer> allcustomers(){
        return customerRepository.findAll();
    }
    @GetMapping("/BookDetails")
    public Book getbook(@RequestParam int id){
        return bookRepository.findById(id);
    }
    @GetMapping("/AllBooks")
    public List<Book> books(){
      return bookRepository.findAll();
    }
    @PostMapping("/ReturnedRentBook")
    public boolean ReturnedRentBook(@RequestParam int id){
        Book b1=bookRepository.findById(id);
        try{

                    if ( b1.isRented()) {
                        b1.setRented(false);
                        Customer c=b1.getCustomer();
                        LocalDate date=LocalDate.now();
                        b1.setReturned(date);
                        LocalDate date1=b1.getTaken();
                        long days= ChronoUnit.DAYS.between(date1,date);
                        if(days>7){
                            days=days%7;
                            c.setTotalRentPrice((int)days* (b1.getRentPrice()));
                        }
                        c.setTotalbooksrent(c.getTotalbooksrent()-1);
                        c.getBooks().remove(b1);
                        c.setBooks(c.getBooks());
                        bookRepository.save(b1);
                        socketService.notifyBookRent("Returned",b1);
                        emailService.sendMail(c.getEmail(),"This Book is Available now",b1.toString());
                    }
                    else{
                        return false;

            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    @GetMapping("/SearchBookById")
    public Book bookIdFinder(@RequestParam int id){
      return bookRepository.findById(id);
    }
    @GetMapping("/SearchCustomerById")
    public Customer customerById(@RequestParam int id){
      return customerRepository.findById(id);
    }
    @GetMapping("/SearchCustomer")
    public List<Customer> details(@RequestParam String name){
        return customerRepository.findByNameContainingIgnoreCase(name);
    }
    @GetMapping("/CustomerDetails")
    public boolean getDetails(@RequestParam String name){
      return customerRepository.findByName(name)==null;
    }
    @GetMapping("/SearchBooks")
    public List<Book> SearchBooks(@RequestParam String name){
        return bookRepository.findByBookNameContainingIgnoreCase(name);
    }
}
