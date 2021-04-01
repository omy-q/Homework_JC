package lesson9;

import java.sql.SQLException;

public class MainClass {

    public static void main(String[] args) {
        try {
            DataBase db = new DataBase();
            db.createTable();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
