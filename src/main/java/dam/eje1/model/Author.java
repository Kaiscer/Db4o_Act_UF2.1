package dam.eje1.model;

public class Author {

    private String initials;
    private String name;
    private String nationality;
    
    

    public Author(String initials, String name, String nationality) {
        this.initials = initials;
        this.name = name;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Author: " + name + "(" + initials + ") - " + nationality;
    }
}
