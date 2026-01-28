package com.example.demo.books;

public class BookMessage {
    private String action;
    private Book book;
    public BookMessage(String action,Book book){
        this.book=book;
        this.action=action;
    }

    public String getAction() {
        return action;
    }
    public Book getBook() {
        return book;
    }

}
