package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import sample.model.Task;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ListController {

    @FXML
    private ListView<Task> listTask;

    @FXML
    private TextField listTaskField;

    @FXML
    private TextField listDescriptionField;

    @FXML
    private Button listSaveTaskButton;

    private  ObservableList<Task> tasks;

    @FXML
    void initialize() {

        System.out.println("User Id from cell controller: " + AddItemController.userId);

        Task myTask = new Task();
        myTask.setTask("Clean Car");
        myTask.setDescription("Have to clean");
        myTask.setDatecreated(Timestamp.valueOf(LocalDateTime.now()));

        Task myTask2 = new Task();
        myTask2.setTask("Clean House");
        myTask2.setDescription("Have to clean it too");
        myTask2.setDatecreated(Timestamp.valueOf(LocalDateTime.now()));


        tasks = FXCollections.observableArrayList();

        tasks.addAll(myTask, myTask2);

        listTask.setItems(tasks);
        listTask.setCellFactory(CellController -> new CellController());


    }
}
