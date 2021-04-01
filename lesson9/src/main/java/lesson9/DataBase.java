package lesson9;
import java.sql.*;

public class DataBase {
    private Connection connection;
    private Statement statement;
    private ResultSet result;
    private String dbName = "dogs.db";

    public void connect() throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
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

    public void insertAllData(Dog dog) throws SQLException{
                statement.executeUpdate("INSERT INTO dogs (name, age, color, breed) " +
                "VALUES (" + "'" + dog.getName() +"', " + dog.getAge() + ", " +
                        "'" + dog.getColor() + "', " + "'" +dog.getBreed() + "');");
    }

    public void updateOneData(String colomnName, String colomnValue, String where) throws SQLException{
        statement.executeUpdate("UPDATE dogs SET " + colomnName + "=" + colomnValue + " WHERE " + where + ";");
    }

    public void updateTwoData(String colomnName1, String colomnValue1, String colomnName2, String colomnValue2, String where) throws SQLException{
        statement.executeUpdate("UPDATE dogs SET " + colomnName1 + "=" + colomnValue1 + ", "
                                                           + colomnName2 + "=" + colomnValue2 +
                                                            " WHERE " + where + ";");
    }

    public void readDB() throws SQLException{
        result = statement.executeQuery("SELECT * FROM dogs;");
        while (result.next()){
            System.out.printf("------Dog------:\n name: %s\n age: %d\n color: %s\n breed: %s\n",
            result.getString("name"), result.getInt("age"),
            result.getString("color"), result.getString("breed"));
        }

    }

    public void readColumn(String colomnName, String where) throws SQLException{
        result = statement.executeQuery("SELECT " + colomnName + " FROM dogs WHERE " + where + ";");
        while (result.next()){
            System.out.printf("------Dog------:\n " + colomnName + ": %s\n", result.getString(colomnName));
        }
    }

    public void disconnect(){
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
