package com.georgebotas.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu implements IMenu {

    @Autowired
    ILibrary ilibrary;

    public Menu() { }

    int userSelect;
    static final Scanner SCAN = new Scanner(System.in);

    @Override
    public void select() {

        String userName;
        String userAuthor;
        Integer userPages;
        String client;
        Long userID;

        userSelect = SCAN.nextInt();
        SCAN.nextLine();

        switch (userSelect) {
            case 1:
                ilibrary.showLibrary();
                reSelect();
                break;
            case 2:
                System.out.println(Print.createName);
                userName = SCAN.nextLine();
                validate_string(userName);
                System.out.println(Print.createAuthor);
                userAuthor = SCAN.nextLine();
                validate_string(userAuthor);
                System.out.println(Print.createPages);
                userPages = SCAN.nextInt();
                SCAN.nextLine();
                ilibrary.createBook(userName, userAuthor, userPages);
                reSelect();
                break;
            case 3:
                System.out.println(Print.bookSelect);
                userID = SCAN.nextLong();
                ilibrary.validateID(userID);
                edit(userID);
                reSelect();
                break;
            case 4:
                System.out.println(Print.bookDelete);
                userID = SCAN.nextLong();
                ilibrary.validateID(userID);
                ilibrary.deleteBook(userID);
                reSelect();
                break;
            case 5:
                System.out.println(Print.bookSelect);
                userID = SCAN.nextLong();
                SCAN.nextLine();
                ilibrary.validateID(userID);
                ilibrary.validateUnavailability(userID);
                System.out.println(Print.bookClient);
                client = SCAN.nextLine();
                ilibrary.checkOut(userID, client);
                reSelect();
                break;
            case 6:
                System.out.println(Print.bookSelect);
                userID = SCAN.nextLong();
                ilibrary.validateID(userID);
                ilibrary.validateAvailability(userID);
                ilibrary.returnBook(userID);
                reSelect();
                break;
            case 7:
                sort();
                reSelect();
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println(Print.invalidNumber);
                reSelect();
                break;
        }
    }

    @Override
    public void reSelect() {
        System.out.println(Print.mainMenu);
        select();
    }

    @Override
    public void edit(Long userID) {
        String userString;
        Integer userInt;
        System.out.println(Print.editMenu);
        userSelect = SCAN.nextInt();
        switch (userSelect) {
            case 1:
                System.out.println(Print.editName);
                SCAN.nextLine();
                userString = SCAN.nextLine();
                validate_string(userString);
                ilibrary.editName(userID, userString);
                break;
            case 2:
                System.out.println(Print.editAuthor);
                SCAN.nextLine();
                userString = SCAN.nextLine();
                validate_string(userString);
                ilibrary.editAuthor(userID, userString);
                break;
            case 3:
                System.out.println(Print.editPages);
                userInt = SCAN.nextInt();
                SCAN.nextLine();
                ilibrary.editPages(userID, userInt);
                break;
            default:
                System.out.println(Print.invalidNumber);
                edit(userID);
                break;
        }
    }

    @Override
    public void sort() {
        System.out.println(Print.sortMenu);
        userSelect = SCAN.nextInt();
        switch (userSelect) {
            case 1:
                System.out.println(Print.sortedName);
                ilibrary.sortBooksName();
                break;
            case 2:
                System.out.println(Print.sortedAuthor);
                ilibrary.sortBooksAuthor();
                break;
            case 3:
                System.out.println(Print.sortedPages);
                ilibrary.sortBooksPages();
                break;
            case 4:
                System.out.println(Print.sortedAvailable);
                ilibrary.sortBooksAvailability();
                break;
            default:
                System.out.println(Print.invalidNumber);
                sort();
                break;
        }
    }

    @Override
    public void validate_int(int userInt) {
        while (!UserInputValidator.validateUserInt(userInt)) {
            System.out.println(Print.invalidNumber);
            userInt = SCAN.nextInt();
        }
    }

    @Override
    public void validate_string(String userString) {
        while (!UserInputValidator.validateUserString(userString)) {
            System.out.println(Print.invalidString);
            userString = SCAN.nextLine();
        }
    }
}
