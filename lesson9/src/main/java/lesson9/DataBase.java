package lesson9;
import java.sql.*;

public class DataBase {
    private Connection connection;
    private Statement statement;
    private String dbName = "dogs.db";

    public DataBase() throws ClassNotFoundException, SQLException{
        Class.forName("org.sglite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
        statement = connection.createStatement();
    }

    public void createTable() throws SQLException{
        statement.execute("CREATE TABLE IF NOT EXISTS dogs (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "name TEXT NOT NULL, " +
                "age INTEGER NOT NULL," +
                "color TEXT NOT NULL," +
                "breed TEXT);");

    }



}
