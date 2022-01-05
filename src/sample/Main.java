package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.DataBase.DatabaseHandler;

import java.sql.ResultSet;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("view/list.fxml"));
        primaryStage.setTitle("ToDoApp");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        DatabaseHandler databaseHandler = new DatabaseHandler();
        ResultSet resultSet = databaseHandler.getTaskByUser(3);

        while (resultSet.next()) {
            System.out.println("User tasks: " + resultSet.getString("task"));
        }

    }


    public static void main(String[] args) {
        launch(args);
    }

}