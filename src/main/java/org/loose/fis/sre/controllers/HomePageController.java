package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.ResourceBundle;

import java.net.URL;

public class HomePageController implements Initializable {

    @FXML
    private Button bookshopsButton;
    @FXML
    private Button myordersButton;
    @FXML
    private Button cancelButton;

    @FXML
    public void cancelButtonOnAction() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void bookshopsPageView() {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("booksList.fxml")));
            Stage registerStage = (Stage) bookshopsButton.getScene().getWindow();
            registerStage.setTitle("Bookshops");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
