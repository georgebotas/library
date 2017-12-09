package com.georgebotas.library.DB;

import com.georgebotas.library.Model.Book;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Component
public class DBOps implements IDBOps {

    public DBOps() { }

    private EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Library");
    private EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
    private EntityTransaction transaction;


    public boolean validateID(Long book_ID) {
        Book book = manager.find(Book.class, book_ID);
        if (book == null) {
            return false;
        }
        return true;
    }

    public boolean validateAvailability(Long book_ID) {
        Book book = manager.find(Book.class, book_ID);
        if (book.isAvailable()) {
            return false;
        }
        return true;
    }

    public boolean validateUnavailability(Long book_ID) {
        Book book = manager.find(Book.class, book_ID);
        if (!book.isAvailable()) {
            return false;
        }
        return true;
    }

    public ArrayList<Book> booksList() {
        ArrayList<Book> books = null;
        transaction = manager.getTransaction();
        transaction.begin();
        books = (ArrayList<Book>) manager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        transaction.commit();
        return books;
    }

    public void createBook(String name, String author, Integer pages) {
        transaction = manager.getTransaction();
        transaction.begin();
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPages(pages);
        book.setAvailable(true);
        book.setClient("NONE");
        manager.persist(book);
        transaction.commit();
    }

    public void editName(Long book_ID, String name) {
        transaction = manager.getTransaction();
        transaction.begin();
        Book book = manager.find(Book.class, book_ID);
        book.setName(name);
        manager.persist(book);
        transaction.commit();
    }

    public void editAuthor(Long book_ID, String author) {
        transaction = manager.getTransaction();
        transaction.begin();
        Book book = manager.find(Book.class, book_ID);
        book.setAuthor(author);
        manager.persist(book);
        transaction.commit();
    }

    public void editPages(Long book_ID, Integer pages) {
        transaction = manager.getTransaction();
        transaction.begin();
        Book book = manager.find(Book.class, book_ID);
        book.setPages(pages);
        manager.persist(book);
        transaction.commit();
    }

    public void deleteBook(Long book_ID) {
        transaction = manager.getTransaction();
        transaction.begin();
        Book book = manager.find(Book.class, book_ID);
        manager.remove(book);
        transaction.commit();
    }

    public void checkout(Long book_ID, String client) {
        Calendar calendar = Calendar.getInstance();
        Date checkOutDate = calendar.getTime();

        calendar.add(Calendar.MONTH, +1);
        Date returnDate = calendar.getTime();
        transaction = manager.getTransaction();
        transaction.begin();
        Book book = manager.find(Book.class, book_ID);
        book.setClient(client);
        book.setCheckOutDate(checkOutDate);
        book.setReturnDate(returnDate);
        book.setAvailable(false);
        transaction.commit();
    }

    public void returnBook(Long book_ID) {
        transaction = manager.getTransaction();
        transaction.begin();
        Book book = manager.find(Book.class, book_ID);
        book.setClient("NONE");
        book.setCheckOutDate(null);
        book.setReturnDate(null);
        book.setAvailable(true);
        transaction.commit();
    }
}