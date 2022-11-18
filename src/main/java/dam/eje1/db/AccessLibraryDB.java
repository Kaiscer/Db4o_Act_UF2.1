package dam.eje1.db;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import dam.eje1.model.Book;

public class AccesoBibliotecaDB {
    static final String PATH_DB = "src/main/resources/BBDD/BibliotecaDB.yap";

    ObjectContainer db;

    public AccesoBibliotecaDB() {
        db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),PATH_DB);
    }

    public void closeDB(){
        db.close();
    }

    public void InsertLibro(Book book){
        db.store(book);
    }

}
