package com.georgebotas.library;

public class Print {
    static String mainMenu = ("THE LIBRARY: PLEASE CHOOSE AN OPTION BY ENTERING THE CORESPONDING NUMBER:\n\n" +
            "1. SHOW ALL BOOKS\n2. ADD A BOOK\n3. EDIT A BOOK\n4. REMOVE A BOOK\n5. CHECK-OUT\n6. RETURN\n7. SORT BOOKS\n8. EXIT");

    static String createName = ("ENTER THE BOOK'S NAME:");
    static String createAuthor = ("ENTER THE BOOK'S AUTHOR:");
    static String createPages = ("ENTER THE BOOKS'S PAGE COUNT:");

    static String editMenu = ("CHOOSE AN OPTION BY ENTERING THE CORESPONDING NUMBER:\n 1. EDIT NAME\n 2. EDIT AUTHOR\n 3. EDIT PAGE COUNT");
    static String editName = ("ENTER THE NEW NAME FOR THE SELECTED BOOK:");
    static String editAuthor = ("ENTER THE NEW AUTHOR FOR THE SELECTED BOOK:");
    static String editPages =("ENTER THE NEW PAGE COUNT FOR THE SELECTED BOOK:");

    static String bookSelect = ("SELECT A BOOK BY ENTERING IT'S ID:");
    static String bookDelete = ("SELECT A BOOK YOU'D LIKE TO DELETE BY ENTERING IT'S ID:");
    static String bookClient = ("ENTER THE NAME OF THE CLIENT THAT BORROWS THE BOOK:");
    static String invalidNumber = ("PLEASE ENTER A VALID NUMBER:");
    static String invalidString = ("PLEASE ENTER A VALID NAME:");
    static String invalidID = ("THE ID YOU HAVE ENTERED DOES NOT EXIST IN THE DATABASE.");
    static String emptyLibrary = ("THE LIBRARY IS EMPTY. PLEASE ADD SOME BOOKS AND TRY AGAIN.");
    static String bookAvailable = ("THIS BOOK ISN'T BURROWED BY ANYONE AT THE MOMENT.");
    static String bookNotAvailable = ("THE BOOK YOU'VE SELECTED IS CURRENTLY CHECKED OUT. PLEASE SELECT ANOTHER OR CHECK AGAIN LATER IF IT HAS BEEN RETURNED.");

    static String sortMenu = ("CHOOSE THE TYPE OF SORTING:\n 1. SORT BY NAME\n 2. SORT BY AUTHOR\n 3. SORT BY PAGE COUNT\n 4. SORT BY AVAILABILITY");
    static String sortedName = ("THE INVENTORY SORTED BY NAME:");
    static String sortedAuthor = ("THE INVENTORY SORTED BY AUTHOR:");
    static String sortedPages = ("THE INVENTORY SORTED BY PAGE COUNT:");
    static String sortedAvailable = ("THE INVENTORY SORTED BY AVAILABILITY:");
}

