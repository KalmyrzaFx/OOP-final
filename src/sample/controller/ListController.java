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

import java.net.URL;
import java.util.ResourceBundle;

public class ListController {

    @FXML
    private ListView<String> listTask;

    @FXML
    private TextField listTaskField;

    @FXML
    private TextField listDescriptionField;

    @FXML
    private Button listSaveTaskButton;
    ObservableList<String> listview = FXCollections.observableArrayList(
            "John",
            "Paolo",
            "Bond",
            "Java",
            "Android"
    );

    @FXML
    void initialize() {

        listTask.setItems(listview);

        listTask.setCellFactory(param -> new Cell());
    }

    static class Cell extends ListCell<String> {
       HBox hBox = new HBox();
       Button helloButton = new Button("Hello");
       Label task = new Label();

       Pane pane = new Pane();

       Image icon = new Image("/sample/assets/addIcon.png");
       ImageView iconImg = new ImageView(icon);

        public Cell() {
            super();

            hBox.getChildren().addAll(iconImg, task, helloButton);
            hBox.setHgrow(pane, Priority.ALWAYS);


        }
        public void updateItem(String taskName, boolean empty) {
            super.updateItem(taskName, empty);
            setText(null);
            setGraphic(null);

            if (taskName != null && !empty) {
                task.setText(taskName);
                setGraphic(hBox);
            }
        }
    }
}
