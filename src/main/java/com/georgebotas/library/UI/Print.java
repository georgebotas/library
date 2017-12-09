package com.georgebotas.library.UI;

public class Print {

    public static void mainMenu() {
        String mainMenu = "THE LIBRARY: PLEASE CHOOSE AN OPTION BY ENTERING THE CORESPONDING NUMBER:\n\n" +
                "1. SHOW ALL BOOKS\n2. ADD A BOOK\n3. EDIT A BOOK\n4. REMOVE A BOOK\n5. CHECK-OUT\n6. RETURN\n7. SORT BOOKS\n8. EXIT";
        System.out.println(mainMenu);
    }

    public static void createName() {
        String createName = "ENTER THE BOOK'S NAME:";
        System.out.println(createName);
    }

    public static void createAuthor() {
        String createAuthor = "ENTER THE BOOK'S AUTHOR:";
        System.out.println(createAuthor);
    }

    public static void createPages() {
        String createPages = "ENTER THE BOOKS'S PAGE COUNT:";
        System.out.println(createPages);
    }

    public static void editMenu() {
        String editMenu = "CHOOSE AN OPTION BY ENTERING THE CORESPONDING NUMBER:\n 1. EDIT NAME\n 2. EDIT AUTHOR\n 3. EDIT PAGE COUNT";
        System.out.println(editMenu);
    }

    public static void editName() {
        String editName = "ENTER THE NEW NAME FOR THE SELECTED BOOK:";
        System.out.println(editName);
    }

    public static void editAuthor() {
        String editAuthor = "ENTER THE NEW AUTHOR FOR THE SELECTED BOOK:";
        System.out.println(editAuthor);
    }

    public static void editPages() {
        String editPages = "ENTER THE NEW PAGE COUNT FOR THE SELECTED BOOK:";
        System.out.println(editPages);
    }

    public static void bookSelect() {
        String bookSelect = "SELECT A BOOK BY ENTERING IT'S ID:";
        System.out.println(bookSelect);
    }

    public static void bookDelete() {
        String bookDelete = "SELECT A BOOK YOU'D LIKE TO DELETE BY ENTERING IT'S ID:";
        System.out.println(bookDelete);
    }

    public static void bookClient() {
        String bookClient = "ENTER THE NAME OF THE CLIENT THAT BORROWS THE BOOK:";
        System.out.println(bookClient);
    }


    public static void invalidNumber() {
        String invalidNumber = "PLEASE ENTER A VALID NUMBER:";
        System.out.println(invalidNumber);
    }

    public static void invalidString() {
        String invalidString = "PLEASE ENTER A VALID NAME:";
        System.out.println(invalidString);
    }

    public static void invalidID() {
        String invalidID = "THE ID YOU HAVE ENTERED DOES NOT EXIST IN THE DATABASE. TRY AGAIN:";
        System.out.println(invalidID);
    }

    public static void emptyLibrary() {
        String emptyLibrary = "THE LIBRARY IS EMPTY. PLEASE ADD SOME BOOKS AND TRY AGAIN.";
        System.out.println(emptyLibrary);
    }

    public static void bookAvailable() {
        String bookAvailable = "THIS BOOK ISN'T BURROWED BY ANYONE AT THE MOMENT. SELECT THE ID OF ONE THAT IS:";
        System.out.println(bookAvailable);
    }

    public static void bookNotAvailable() {
        String bookNotAvailable = "THE BOOK YOU'VE SELECTED IS CURRENTLY CHECKED OUT. PLEASE SELECT ANOTHER OR CHECK AGAIN LATER IF IT HAS BEEN RETURNED.";
        System.out.println(bookNotAvailable);
    }

    public static void sortMenu() {
        String sortMenu = "CHOOSE THE TYPE OF SORTING:\n 1. SORT BY NAME\n 2. SORT BY AUTHOR\n 3. SORT BY PAGE COUNT\n 4. SORT BY AVAILABILITY";
        System.out.println(sortMenu);
    }

    public static void sortName() {
        String sortedName = "THE LIBRARY SORTED BY NAME:";
        System.out.println(sortedName);
    }

    public static void sortAuthor() {
        String sortedAuthor = "THE LIBRARY SORTED BY AUTHOR:";
        System.out.println(sortedAuthor);
    }


    public static void sortPages() {
        String sortedPages = "THE LIBRARY SORTED BY PAGE COUNT:";
        System.out.println(sortedPages);
    }

    public static void sortAvailable() {
        String sortedAvailable = "THE LIBRARY SORTED BY AVAILABILITY:";
        System.out.println(sortedAvailable);
    }

    public static void exception() {
        String exception = "AN EXCEPTION OCCURED. THE PROGRAM WILL NOW EXIT.";
        System.out.println(exception);
    }
}

