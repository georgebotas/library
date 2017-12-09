package com.georgebotas.library.UI;

import com.georgebotas.library.Middleware.ILibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu implements IMenu {

    @Autowired
    ILibrary ilibrary;

    public Menu() { }

    private final Logger logger = LogManager.getLogger();
    private Long bookID;
    private int userSelect;
    private static final Scanner SCAN = new Scanner(System.in);

    public void select() {

        Print.mainMenu();
        userSelect = SCAN.nextInt();
        SCAN.nextLine();

        switch (userSelect) {
            case 1:
                showLibrary();
                break;
            case 2:
                create();
                break;
            case 3:
                editBook();
                break;
            case 4:
                delete();
                break;
            case 5:
                checkOut();
                break;
            case 6:
                returnBook();
                break;
            case 7:
                sort();
                break;
            case 8:
                System.exit(0);
                break;
            default:
                Print.invalidNumber();
                select();
                break;
        }
    }

    private void showLibrary() {
        logger.info("ATTEMPTING TO SHOW ALL LIBRARY.");
        ilibrary.showLibrary();
        logger.info("OPERATION SUCCESSFUL.");
        select();
    }

    private void create() {
        String bookName;
        String bookAuthor;
        Integer bookPages;
        logger.info("ATTEMPTING BOOK CREATION. USER INPUT EXPECTED.");
        Print.createName();
        bookName = SCAN.nextLine();
        validate_string(bookName);
        Print.createAuthor();
        bookAuthor = SCAN.nextLine();
        validate_string(bookAuthor);
        Print.createPages();
        bookPages = SCAN.nextInt();
        SCAN.nextLine();
        ilibrary.createBook(bookName, bookAuthor, bookPages);
        logger.info("BOOK WITH THE NAME '" + bookName + "', AUTHOR '" + bookAuthor + "' AND PAGE-COUNT '" + bookPages + "' HAS BEEN SUCCESSFULLY CREATED.");
        select();
    }

    private void delete() {
        Print.bookDelete();
        bookID = SCAN.nextLong();
        SCAN.nextLine();
        while (!ilibrary.validateID(bookID)) {
            Print.invalidID();
            bookID = SCAN.nextLong();
            SCAN.nextLine();
        }
        logger.info("THE BOOK WITH THE ID '" + bookID + "' HAS BEEN SELECTED FOR REMOVAL.");
        ilibrary.deleteBook(bookID);
        logger.info("THE BOOK WITH THE ID '" + bookID + "' HAS BEEN SUCCESSFULLY REMOVED.");
        select();
    }

    private void checkOut(){
        Print.bookSelect();
        bookID = SCAN.nextLong();
        SCAN.nextLine();
        while (!ilibrary.validateID(bookID)) {
            Print.invalidID();
            bookID = SCAN.nextLong();
            SCAN.nextLine();
        }
        while(!ilibrary.validateUnavailability(bookID)){
            Print.bookNotAvailable();
            bookID = SCAN.nextLong();
            SCAN.nextLine();
        }
        logger.info("THE BOOK WITH THE ID '" + bookID + "' HAS BEEN SELECTED FOR CHECK-OUT.");
        Print.bookClient();
        String client = SCAN.nextLine();
        ilibrary.checkOut(bookID, client);
        logger.info("THE BOOK WITH THE ID '" + bookID + "' HAS BEEN BORROWED BY " + client + ".");
        select();
    }

    private void returnBook(){
        Print.bookSelect();
        bookID = SCAN.nextLong();
        SCAN.nextLine();
        while (!ilibrary.validateID(bookID)) {
            Print.invalidID();
            bookID = SCAN.nextLong();
            SCAN.nextLine();
        }
        while(!ilibrary.validateAvailability(bookID)){
            Print.bookAvailable();
            bookID = SCAN.nextLong();
            SCAN.nextLine();
        }
        logger.info("THE BOOK WITH THE ID '" + bookID + "' HAS BEEN SELECTED FOR RETURNING.");
        ilibrary.returnBook(bookID);
        logger.info("THE BOOK WITH THE ID '" + bookID + "' HAS BEEN RETURNED.");
        select();
    }

    private void editBook() {
        Print.bookSelect();
        bookID = SCAN.nextLong();
        SCAN.nextLine();
        while (!ilibrary.validateID(bookID)) {
            Print.invalidID();
            bookID = SCAN.nextLong();
            SCAN.nextLine();
        }
        logger.info("THE BOOK WITH THE ID '" + bookID + "' HAS BEEN SELECTED FOR EDITING.");
        edit(bookID);
        select();
    }

    private void edit(Long userID) {
        String userString;
        Integer userInt;
        Print.editMenu();
        userSelect = SCAN.nextInt();
        SCAN.nextLine();
        switch (userSelect) {
            case 1:
                Print.editName();
                userString = SCAN.nextLine();
                validate_string(userString);
                ilibrary.editName(userID, userString);
                logger.info("THE BOOK'S NAME WITH THE ID '" + bookID + "' HAS CHANGED TO '" + userString +"'.");
                break;
            case 2:
                Print.editAuthor();
                userString = SCAN.nextLine();
                validate_string(userString);
                ilibrary.editAuthor(userID, userString);
                logger.info("THE BOOK'S AUTHOR WITH THE ID '" + bookID + "' HAS CHANGED TO '" + userString +"'.");
                break;
            case 3:
                Print.editPages();
                userInt = SCAN.nextInt();
                SCAN.nextLine();
                ilibrary.editPages(userID, userInt);
                logger.info("THE BOOK'S PAGE-COUNT WITH THE ID '" + bookID + "' HAS CHANGED TO '" + userInt +"'.");
                break;
            default:
                Print.invalidNumber();
                edit(userID);
                break;
        }
    }

    private void sort() {
        Print.sortMenu();
        userSelect = SCAN.nextInt();
        SCAN.nextLine();
        switch (userSelect) {
            case 1:
                Print.sortName();
                logger.info("ATTEMPTING TO SORT AND LIST THE LIBRARY BY THE BOOKS' TITLES.");
                ilibrary.sortBooksName();
                logger.info("SORTING SUCCESSFUL");
                select();
                break;
            case 2:
                Print.sortAuthor();
                logger.info("ATTEMPTING TO SORT AND LIST THE LIBRARY BY THE BOOKS' AUTHORS.");
                ilibrary.sortBooksAuthor();
                logger.info("SORTING SUCCESSFUL");
                select();
                break;
            case 3:
                Print.sortPages();
                logger.info("ATTEMPTING TO SORT AND LIST THE LIBRARY BY THE BOOKS' PAGE-COUNT.");
                ilibrary.sortBooksPages();
                logger.info("SORTING SUCCESSFUL");
                select();
                break;
            case 4:
                Print.sortAvailable();
                logger.info("ATTEMPTING TO SORT AND LIST THE LIBRARY BY THE BOOKS' AVAILABILITY.");
                ilibrary.sortBooksAvailability();
                logger.info("SORTING SUCCESSFUL");
                select();
                break;
            default:
                Print.invalidNumber();
                sort();
                break;
        }
    }

    private void validate_int(int userInt) {
        while (!UserInputValidator.validateUserInt(userInt)) {
            Print.invalidNumber();
            userInt = SCAN.nextInt();
        }
    }

    private void validate_string(String userString) {
        while (!UserInputValidator.validateUserString(userString)) {
            Print.invalidString();
            userString = SCAN.nextLine();
        }
    }
}
