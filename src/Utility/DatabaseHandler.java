package Utility;

import Exceptions.DatabaseConnectException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {
    private final String url = "jdbc:postgresql://localhost:9999/TestovoeZadanie";
    private final String user = "postgres";
    private final String password = "1111";

    public Connection connectToDatabase() throws DatabaseConnectException{
        try{
            return DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            throw new DatabaseConnectException("can't connect to db");
        }
    }

}
