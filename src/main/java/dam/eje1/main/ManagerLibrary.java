package dam.eje1.main;

import dam.eje1.db.AccesoBibliotecaDB;

import java.util.Scanner;

public class ManagerBibli {

    static AccesoBibliotecaDB accessDB;

    static Scanner sc;

    static final String INSERTA_LIBRO = "IL";
    static final String MODIFICAR_LIBRO = "ML";
    static final String CONSULTAR_TODOS = "CT";
    static final String CONSULTAR_MENOS_PG = "CL";
    static final String TERMINAR_PROCESO = "S";


    public static void main(String[] args) {

        accessDB = new AccesoBibliotecaDB();
        sc = new Scanner(System.in);


        menu(sc);




    }

    private static void menu(Scanner sc) {
        String opcion;
        boolean dataOk = false;

        while (!dataOk){
            System.out.println("");
        }

    }

}
