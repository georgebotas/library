package com.georgebotas.library.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book {

    public Book() { }

    public Book(String name, String author, Integer pages) {
        this.name = name;
        this.author = author;
        this.pages = pages;
    }

    private String name;
    private String author;
    private Integer pages;
    private String client;
    private Date checkOutDate;
    private Date returnDate;
    private boolean available;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public Integer getPages() { return pages; }

    public void setPages(Integer pages) { this.pages = pages; }

    public String getClient() { return client; }

    public void setClient(String client) { this.client = client; }

    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) { this.available = available; }

    public Date getCheckOutDate() { return checkOutDate; }

    public void setCheckOutDate(Date checkOutDate) { this.checkOutDate = checkOutDate; }

    public Date getReturnDate() { return returnDate; }

    public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }

    public Long getBook_id() { return book_id; }

    public void setBook_id(Long book_id) { this.book_id = book_id; }
}
