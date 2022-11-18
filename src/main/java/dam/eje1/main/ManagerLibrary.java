package dam.eje1.main;

import dam.eje1.db.AccessLibraryDB;
import dam.eje1.model.Author;
import dam.eje1.model.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerLibrary {

    static AccessLibraryDB accessDB;

    static Scanner sc;

    static final String INSERT_BOOK = "IB";
    static final String MODIFY_BOOK = "MB";
    static final String CHECK_ALL_BOOK = "CAB";
    static final String CHECK_MAYOR_P = "CMP";
    static final String END_PROCESS = "END";
    static final int FILTER_PAG = 300;

    static final String[] textMenu = {"\n-Enter IB to insert to Author and Book.",
                                        "-Enter MB to modify to number of page of a book.",
                                        "-Enter CAB to view all the books.",
                                        "-Enter CMP to view books of more than 300 pages.",
                                        "-Enter END to Finished the process."};


    public static void main(String[] args) {

        accessDB = new AccessLibraryDB();
        sc = new Scanner(System.in);


        String str = "";

        while(!str.equalsIgnoreCase(END_PROCESS)){
            str = showMenuOption(sc);
            manipulationDB(str.toUpperCase().trim());
        }

        accessDB.closeDB();


    }

    private static void manipulationDB(String str) {

        switch (str){
            case INSERT_BOOK:
                insertAuthorBook();
                break;
            case MODIFY_BOOK:
                modifyBook();
                break;
            case CHECK_ALL_BOOK:
                checkAllBooks();
                break;
            case CHECK_MAYOR_P:
                checkMayorP();
                break;
            default:
                System.out.println("Closes the application.");
                break;
        }

    }

    private static void checkMayorP() {
        ArrayList<Book> listBooks = accessDB.checkBooksByPages(FILTER_PAG);

        if (listBooks.isEmpty()){
            System.out.println("No book has been found with more than " + FILTER_PAG + " pages in the database");
        }else {
            System.out.println("List books registered more tha " + FILTER_PAG + " pages");
            for (Book book : listBooks){
                System.out.println(book);
            }
        }


    }

    private static void checkAllBooks() {
       ArrayList<Book> listAllBooks = accessDB.checkBooks();
       if (listAllBooks.isEmpty()){
           System.out.println("No books registered in the DB");
       }else {
           System.out.println("Books registered in the DataBase:");
           for (Book book : listAllBooks){
               System.out.println(book);
           }
       }
    }

    private static void modifyBook() {
        ArrayList<Book> listBooks = accessDB.checkBooks();
        if (listBooks.isEmpty()){
            System.out.println("No books registered in the DB");
        }else {
            String newTitle = requestStr("Enter the new title of book");
            int newNumbPage = requestNumPages("Enter the new number of pages");

            int book = accessDB.modifyBook(newTitle, newNumbPage);
            System.out.println("The number of page of " + book + " book has been modified.");
        }

    }



    private static void insertAuthorBook() {
        Book book = requestDataBook();
        int element = accessDB.InsertBook(book);

        if (element == 2){
            System.out.println("The book and the Author have been introduced");
        }else {
            System.out.println("Book added! the Author is already registered at DB");
        }

    }

    private static Book requestDataBook() {
        String title = requestStr("Enter the title of book");

        Author author = requestDataAuthor();

        int numPag = requestNumPages("Enter the number of pages the book");


        return new Book(title,author, numPag);
    }

    private static int requestNumPages(String msg) {
        int pages = 0;

        while (true){
            try{

                System.out.println(msg);
                pages = Integer.parseInt(sc.nextLine());
                if (pages > 0){
                    break;
                }

            }catch (NumberFormatException e){
                System.out.println("The value is incorrect");
            }
        }
        return pages;
    }

    private static Author requestDataAuthor() {

        String initials = requestStr("Enter the initials of Author");

        String name = requestStr("Enter name of Author");

        String nationality = requestStr("Enter the nationality of Author");


        return new Author(initials,name,nationality);
    }

    private static String requestStr(String msg) {
        String text ="";

        while (text.isBlank()){
            System.out.println(msg);
            text = sc.nextLine().trim();

            if (text.isBlank()){
                System.out.println("You must enter the requested text string");
            }
        }

        return text;
    }

    private static String showMenuOption(Scanner sc) {
        String str ="";
        System.out.println("Chose the option you wish to perform:");
        while (true){

            for (int i = 0; i < textMenu.length; i++) {
                System.out.println(textMenu[i]);
            }
                str = sc.nextLine();
                if (str.equalsIgnoreCase(INSERT_BOOK) || str.equalsIgnoreCase(MODIFY_BOOK) ||
                    str.equalsIgnoreCase(CHECK_ALL_BOOK) || str.equalsIgnoreCase(CHECK_MAYOR_P) || str.equalsIgnoreCase(END_PROCESS)){
                    return str;
                }else {
                    System.out.println("something's wrong! Please read the options carefully ");

                }
        }

    }

}
