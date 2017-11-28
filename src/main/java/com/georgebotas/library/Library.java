package com.georgebotas.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Component
public class Library implements ILibrary {

    @Autowired
    IDBOps idbops;

    public Library() { }

    @Override
    public void validateID(Long book_ID) {
        idbops.validateID(book_ID);
    }

    @Override
    public void validateAvailability(Long book_ID) {
        idbops.validateAvailability(book_ID);
    }

    @Override
    public void validateUnavailability(Long book_ID){
        idbops.validateUnavailability(book_ID);
    }

    @Override
    public void showLibrary() {
        ArrayList<Book> books = idbops.booksList();
        int count = 0;
        System.out.printf("%-10s %-21s %-21s %-21s %-21s %-21s %-30s %s \n", "   ID:", "NAME:", "AUTHOR:", "NUMBER OF PAGES:", "AVAILABLE:", "CURRENT OWNER:", "CHECK-OUT DATE:",
                "EXPECTED RETURN DATE:");
        try {
            for (Book book : books) {
                System.out.printf("%d. %-7s %-21s %-21s %-21s %-21s %-21s %-30s %s \n", count + 1, book.getBook_id(), book.getName(), book.getAuthor(),
                        book.getPages(), book.isAvailable() ? "YES" : "NO", book.getClient(), book.getCheckOutDate() == null ? "NONE" : book.getCheckOutDate(),
                        book.getReturnDate() == null ? "NONE" : book.getReturnDate());
                count++;
            }
            System.out.println();
        } catch (NullPointerException ne) {
            System.out.println(Print.emptyLibrary);
        }
    }

    @Override
    public void createBook(String name, String author, Integer pages){ idbops.createBook(name, author, pages);}

    @Override
    public void deleteBook(Long book_ID) { idbops.deleteBook(book_ID); }

    @Override
    public void editName(Long book_ID, String name) { idbops.editName(book_ID, name);}

    @Override
    public void editAuthor(Long book_ID, String author) { idbops.editAuthor(book_ID, author);}

    @Override
    public void editPages(Long book_ID, Integer pages) { idbops.editPages(book_ID, pages);}

    @Override
    public void checkOut(Long book_ID, String client) { idbops.checkout(book_ID, client);}

    @Override
    public void returnBook(Long book_ID) { idbops.returnBook(book_ID);}

    @Override
    public void sortBooksName() {

        ArrayList<Book> books = idbops.booksList();
        int count = 0;
        Collections.sort(books, new Comparator<Book>() {
            public int compare(Book b1, Book b2) {
                return b1.getName().compareTo(b2.getName());
            }
        });
        System.out.printf("%-10s %-21s %-21s %-21s %-21s %-21s %-30s %s \n", "   ID:", "NAME:", "AUTHOR:", "NUMBER OF PAGES:", "AVAILABLE:", "CURRENT OWNER:", "CHECK-OUT DATE:",
                "EXPECTED RETURN DATE:");
        for (Book book: books) {
            System.out.printf("%d. %-7s %-21s %-21s %-21s %-21s %-21s %-30s %s \n", count + 1, book.getBook_id(), book.getName(), book.getAuthor(),
                    book.getPages(), book.isAvailable() ? "YES" : "NO", book.getClient(), book.getCheckOutDate() == null ? "NONE" : book.getCheckOutDate(),
                    book.getReturnDate() == null ? "NONE" : book.getReturnDate());
            count++;
        }
        System.out.println();
    }

    @Override
    public void sortBooksAuthor() {

        ArrayList<Book> books = idbops.booksList();
        int count = 0;
        Collections.sort(books, new Comparator<Book>() {
            public int compare(Book b1, Book b2) {
                return b1.getAuthor().compareTo(b2.getAuthor());
            }
        });
        System.out.printf("%-10s %-21s %-21s %-21s %-21s %-21s %-30s %s \n", "   ID:", "NAME:", "AUTHOR:", "NUMBER OF PAGES:", "AVAILABLE:", "CURRENT OWNER:", "CHECK-OUT DATE:",
                "EXPECTED RETURN DATE:");
        for (Book book: books) {
            System.out.printf("%d. %-7s %-21s %-21s %-21s %-21s %-21s %-30s %s \n", count + 1, book.getBook_id(), book.getName(), book.getAuthor(),
                    book.getPages(), book.isAvailable() ? "YES" : "NO", book.getClient(), book.getCheckOutDate() == null ? "NONE" : book.getCheckOutDate(),
                    book.getReturnDate() == null ? "NONE" : book.getReturnDate());
            count++;
        }
        System.out.println();
    }

    @Override
    public void sortBooksPages() {

        ArrayList<Book> books = idbops.booksList();
        int count = 0;
        Collections.sort(books, new Comparator<Book>() {
            public int compare(Book b1, Book b2) {
                return b2.getPages()- b1.getPages();
            }
        });
        System.out.printf("%-10s %-21s %-21s %-21s %-21s %-21s %-30s %s \n", "   ID:", "NAME:", "AUTHOR:", "NUMBER OF PAGES:", "AVAILABLE:", "CURRENT OWNER:", "CHECK-OUT DATE:",
                "EXPECTED RETURN DATE:");
        for (Book book: books) {
            System.out.printf("%d. %-7s %-21s %-21s %-21s %-21s %-21s %-30s %s \n", count + 1, book.getBook_id(), book.getName(), book.getAuthor(),
                    book.getPages(), book.isAvailable() ? "YES" : "NO", book.getClient(), book.getCheckOutDate() == null ? "NONE" : book.getCheckOutDate(),
                    book.getReturnDate() == null ? "NONE" : book.getReturnDate());
            count++;
        }
        System.out.println();
    }

    @Override
    public void sortBooksAvailability() {

        ArrayList<Book> books = idbops.booksList();
        int count = 0;
        Collections.sort(books, new Comparator<Book>() {
            public int compare(Book b1, Book b2) {
                return Boolean.valueOf(b2.isAvailable()).compareTo(Boolean.valueOf(b1.isAvailable()));
            }
        });
        System.out.printf("%-10s %-21s %-21s %-21s %-21s %-21s %-30s %s \n", "   ID:", "NAME:", "AUTHOR:", "NUMBER OF PAGES:", "AVAILABLE:", "CURRENT OWNER:", "CHECK-OUT DATE:",
                "EXPECTED RETURN DATE:");
        for (Book book: books) {
            System.out.printf("%d. %-7s %-21s %-21s %-21s %-21s %-21s %-30s %s \n", count + 1, book.getBook_id(), book.getName(), book.getAuthor(),
                    book.getPages(), book.isAvailable() ? "YES" : "NO", book.getClient(), book.getCheckOutDate() == null ? "NONE" : book.getCheckOutDate(),
                    book.getReturnDate() == null ? "NONE" : book.getReturnDate());
            count++;
        }
        System.out.println();
    }

}
