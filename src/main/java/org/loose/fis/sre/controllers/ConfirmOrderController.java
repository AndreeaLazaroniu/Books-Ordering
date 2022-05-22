package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.loose.fis.sre.services.BookService;
import org.loose.fis.sre.services.OrderBookService;

import java.io.IOException;
import java.util.Objects;

public class ConfirmOrderController {
    @FXML
    private Text errorMessage;
    @FXML
    private TextField nameField;
    @FXML
    private Button cancelButton;
    @FXML
    private Button confirmButton;

    @FXML
    public void cancelButtonOnAction()
    {
        backToListBooksForm();
    }

    @FXML
    public void backToListBooksForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("myOrders.fxml")));
            Stage registerStage = (Stage) cancelButton.getScene().getWindow();
            registerStage.setTitle("My Orders Page");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            errorMessage.setText("error");
        }
    }

    @FXML
    public void confirmButtonOnAction() {
        OrderBookService.deleteOrder(nameField.getText());
        backToListBooksForm();
    }


}
