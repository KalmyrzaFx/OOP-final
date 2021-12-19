package sample.DataBase;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:postgresql://" + dbHost + ":"
                +dbPort + "/"
                +dbName;
        Class.forName("org.postgresql.Driver");

        dbConnection = DriverManager.getConnection(connectionString,dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(String firstName, String lastName, String userName,
                           String password, String location, String gender) {
        String insert = "INSERT INTO "+Const.STUDENT_TABLE +"("+Const.STUDENT_FIRSTNAME
                +","+Const.STUDENT_LASTNAME+","+Const.STUDENT_USERNAME+","
                +Const.STUDENT_PASSWORD+","+Const.STUDENT_LOCATION+","
                +Const.STUDENT_GENDER+")" + "VALUES(?,?,?,?,?,?)";

        try  {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, location);
            preparedStatement.setString(6, gender);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}