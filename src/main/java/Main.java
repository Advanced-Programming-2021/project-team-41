import controller.AppController;
import model.database.DataBase;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.run();
        System.out.println("Yo-Gi-Oh!!!!");
        AppController.getInstance().run();
        System.out.println("Bye");
        dataBase.close();
    }
}
