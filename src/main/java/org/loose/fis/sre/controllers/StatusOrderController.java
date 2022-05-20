package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import org.loose.fis.sre.services.BookService;
import org.loose.fis.sre.services.OrderService;

import java.io.IOException;

public class StatusOrderController {
    @FXML
    private Text errorMessage;
    @FXML
    private TextField nameField;
    @FXML
    private TextField statusField;
    @FXML
    private Button cancelButton;
    @FXML
    private Button okButton;

    @FXML
    public void cancelButtonOnAction()
    {
        backToListOrdersForm();
    }

    @FXML
    public void backToListOrdersForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("listOrders.fxml"));
            Stage registerStage = (Stage) cancelButton.getScene().getWindow();
            registerStage.setTitle("List of Orders");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            errorMessage.setText("error");
        }
    }

    @FXML
    public void handleStatusAction() {
        OrderService.editStatus(nameField.getText(), statusField.getText());
        backToListOrdersForm2();
    }

    @FXML
    public void backToListOrdersForm2() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("listOrders.fxml"));
            Stage registerStage = (Stage) okButton.getScene().getWindow();
            registerStage.setTitle("List of Orders");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            errorMessage.setText("error");
        }
    }

}
