package dam.eje1.model;

public class Libro {

    private String titulo;
    private Author author;
    private int numPag;

    public Libro(String titulo, Author author, int numPag) {
        this.titulo = titulo;
        this.author = author;
        this.numPag = numPag;
    }

    public String getTitulo() {
        return titulo;
    }

    public Author getAutor() {
        return author;
    }

    public int getNumPag() {
        return numPag;
    }
}
