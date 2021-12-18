package sample.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:postgresql://" + dbHost + ":"
                +dbPort + "/"
                +dbName;
        Class.forName("com.postgresql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,dbUser, dbPass);

        return dbConnection;
    }
}