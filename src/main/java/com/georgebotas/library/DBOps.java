package com.georgebotas.library;

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


    @Override
    public void validateID(Long book_ID) {

        transaction = manager.getTransaction();
        transaction.begin();
        Book book = manager.find(Book.class, book_ID);
        if (book == null) {
            System.out.println(Print.invalidID);
            System.exit(0);
        }
    }

    @Override
    public void validateAvailability(Long book_ID) {

        Book book = manager.find(Book.class, book_ID);
        if (book.isAvailable()) {
            System.out.println(Print.bookAvailable);
            System.exit(0);
        }
    }

    @Override
    public void validateUnavailability(Long book_ID) {

        Book book = manager.find(Book.class, book_ID);
        if (!book.isAvailable()) {
            System.out.println(Print.bookNotAvailable);
            System.exit(0);
        }
    }

    @Override
    public ArrayList<Book> booksList() {
        ArrayList<Book> books = null;
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            books = (ArrayList<Book>) manager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        return books;
    }

    @Override
    public void createBook(String name, String author, Integer pages) {
        try {
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
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void editName(Long book_ID, String name) {
        try {
            Book book = manager.find(Book.class, book_ID);
            book.setName(name);
            manager.persist(book);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void editAuthor(Long book_ID, String author) {
        try {
            Book book = manager.find(Book.class, book_ID);
            book.setAuthor(author);
            manager.persist(book);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void editPages(Long book_ID, Integer pages) {
        try {
            Book book = manager.find(Book.class, book_ID);
            book.setPages(pages);
            manager.persist(book);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteBook(Long book_ID) {
        try {
            Book book = manager.find(Book.class, book_ID);
            manager.remove(book);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void checkout(Long book_ID, String client) {
        try {
            Calendar calendar = Calendar.getInstance();
            Date checkOutDate = calendar.getTime();

            calendar.add(Calendar.MONTH, +1);
            Date returnDate = calendar.getTime();

            Book book = manager.find(Book.class, book_ID);
            book.setClient(client);
            book.setCheckOutDate(checkOutDate);
            book.setReturnDate(returnDate);
            book.setAvailable(false);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void returnBook(Long book_ID) {
        try {
            Book book = manager.find(Book.class, book_ID);
            book.setClient("NONE");
            book.setCheckOutDate(null);
            book.setReturnDate(null);
            book.setAvailable(true);
            transaction.commit();
        }   catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}