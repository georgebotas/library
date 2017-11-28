package com.georgebotas.library;

import java.util.ArrayList;

public interface IDBOps {
    void validateID(Long book_ID);

    void validateAvailability(Long book_ID);

    void validateUnavailability(Long book_ID);

    ArrayList<Book> booksList();

    void createBook(String name, String author, Integer pages);

    void editName(Long book_ID, String name);

    void editAuthor(Long book_ID, String author);

    void editPages(Long book_ID, Integer pages);

    void deleteBook(Long book_ID);

    void checkout(Long book_ID, String client);

    void returnBook(Long book_ID);
}
