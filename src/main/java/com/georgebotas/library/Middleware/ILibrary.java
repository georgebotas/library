package com.georgebotas.library.Middleware;

public interface ILibrary {

    boolean validateID(Long book_ID);

    boolean validateAvailability(Long book_ID);

    boolean validateUnavailability(Long book_ID);

    void showLibrary();

    void createBook(String name, String author, Integer pages);

    void deleteBook(Long book_ID);

    void editName(Long book_ID, String name);

    void editAuthor(Long book_ID, String author);

    void editPages(Long book_ID, Integer pages);

    void checkOut(Long book_ID, String client);

    void returnBook(Long book_ID);

    void sortBooksName();

    void sortBooksAuthor();

    void sortBooksPages();

    void sortBooksAvailability();
}
