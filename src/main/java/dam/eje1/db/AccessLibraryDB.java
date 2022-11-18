package dam.eje1.db;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import dam.eje1.model.Author;
import dam.eje1.model.Book;

import java.util.ArrayList;

public class AccessLibraryDB {
    static final String PATH_DB = "src/main/resources/BBDD/LibraryDB.yap";

    ObjectContainer db;

    public AccessLibraryDB() {
        db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),PATH_DB);
    }

    public void closeDB(){
        db.close();
    }

    public int InsertBook(Book book){
        //we check if the Author exists
        Author author = checkAuthor(book.getAuthor());

        int element = 2;
        db.store(book);

        return element;
    }

    private Author checkAuthor(Author author) {
        Author existingAuthor = null;
        ObjectSet<Author> setAuthor = db.queryByExample(author);

        if (setAuthor.hasNext()) existingAuthor = setAuthor.next();
        return existingAuthor;
    }

    public ArrayList<Book> checkBooks() {
        ObjectSet<Book> setBooks = db.queryByExample(Book.class);
        return new ArrayList<>(setBooks);
    }

    /**
     *
     * The first thing we do is to check the title of the book.
     *
     * @param title
     * @param numPage
     * @return
     */
    public int modifyBook(String title, int numPage) {
        ArrayList<Book> listBookByTitle = consultByTitle(title);

        int amendedBooks = 0;
        for (Book book : listBookByTitle){
            book.setNumPag(numPage);
            amendedBooks++;
        }
        return amendedBooks;
    }

    /**
     * If the book exists, we assign the new title
     * 1- We create constructor without attributes
     * to be able to assign the title and number of pages
     * to the book we are going to modify
     * 2- with the method set we assign the title
     * @param title
     * @return
     */
    private ArrayList<Book> consultByTitle(String title) {
        Book bookExists = new Book();
        bookExists.setTitle(title);

        ObjectSet<Book> setBook = db.queryByExample(title);

        return new ArrayList<>(setBook);
    }

    public ArrayList<Book> checkBooksByPages(int filterPag) {
        Query check = db.query();
        check.constrain(Book.class);

        check.descend(Book.ATT_NUM_PAG).constrain(filterPag).greater();
        ObjectSet<Book> setBookByPages = check.execute();
        return new ArrayList<>(setBookByPages);
    }
}
