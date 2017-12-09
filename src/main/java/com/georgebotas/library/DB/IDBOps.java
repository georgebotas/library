package com.georgebotas.library.DB;

import com.georgebotas.library.Model.Book;

import java.util.ArrayList;

public interface IDBOps {

    boolean validateID(Long book_ID);

    boolean validateAvailability(Long book_ID);

    boolean validateUnavailability(Long book_ID);

    ArrayList<Book> booksList();

    void createBook(String name, String author, Integer pages);

    void editName(Long book_ID, String name);

    void editAuthor(Long book_ID, String author);

    void editPages(Long book_ID, Integer pages);

    void deleteBook(Long book_ID);

    void checkout(Long book_ID, String client);

    void returnBook(Long book_ID);
}
