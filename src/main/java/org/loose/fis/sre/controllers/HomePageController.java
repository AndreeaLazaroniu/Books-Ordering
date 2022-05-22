package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
    private Text errorMessage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void bookshopsPageView() {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("booksList.fxml")));
            Stage registerStage = (Stage) bookshopsButton.getScene().getWindow();
            registerStage.setTitle("Bookshop");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void myOrdersOnAction()
    {
        ToMyOrdersPageForm();
    }
    
    @FXML
    public void ToMyOrdersPageForm() {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("myOrders.fxml")));
            Stage registerStage = (Stage) myordersButton.getScene().getWindow();
            registerStage.setTitle("My orders");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        } catch (IOException e) {
        e.printStackTrace();
    }
    }
    @FXML
    public void cancelButtonOnAction()
    {
        backToHomePageForm();
    }

    @FXML
    public void backToHomePageForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("login.fxml")));
            Stage registerStage = (Stage) cancelButton.getScene().getWindow();
            registerStage.setTitle("Login");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            errorMessage.setText("error");
        }
    }
}
