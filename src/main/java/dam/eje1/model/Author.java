package dam.eje1.model;

public class Autor {

    private String iniciles;
    private String nombre;
    private String infoLibro;

    public Autor(String iniciles, String nombre, String infoLibro) {
        this.iniciles = iniciles;
        this.nombre = nombre;
        this.infoLibro = infoLibro;
    }

    public String getIniciles() {
        return iniciles;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInfoLibro() {
        return infoLibro;
    }
}
