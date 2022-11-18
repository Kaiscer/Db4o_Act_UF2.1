package dam.eje1.model;

public class Book {

    public static final String ATT_NUM_PAG = "numPag";
    private String title;
    private Author author;
    private int numPag;

    public Book() {
    }

    public Book(String title, Author author, int numPag) {
        this.title = title;
        this.author = author;
        this.numPag = numPag;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    @Override
    public String toString() {
        return "Book: " + title + " - " + numPag + " pages \n" + author;
    }
}
