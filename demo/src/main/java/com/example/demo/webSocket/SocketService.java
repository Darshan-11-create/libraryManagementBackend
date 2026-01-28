package com.example.demo.webSocket;

import com.example.demo.books.Book;
import com.example.demo.books.BookMessage;
//import com.example.demo.user.CustomerMessage.AllCustomerMessage;
import com.example.demo.user.Customer;
import com.example.demo.user.CustomerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

//import java.awt.print.Book;

@Service
public class SocketService {
    @Autowired
    private SimpMessagingTemplate template;
    public void notifyBookRent(String action,Book book){
        BookMessage message=new BookMessage(action,book);
      template.convertAndSend("/topic/books",message);
    }
    public void customerRemover(String action, Customer customer){
        CustomerMessage message=new CustomerMessage(action,customer);
        template.convertAndSend("/topic/customer",message);
    }
}
