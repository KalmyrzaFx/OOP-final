package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
            "Paulo",
            "Bond",
            "Java",
            "Paulo",
            "Bond",
            "Java",
            "Paulo",
            "Bond",
            "Java",
            "Android"

    );

    @FXML
    void initialize(){


            }
}

