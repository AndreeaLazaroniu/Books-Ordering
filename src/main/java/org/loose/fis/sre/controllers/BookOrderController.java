 package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.loose.fis.sre.services.OrderBookService;

import java.io.IOException;
import java.util.Objects;

public class BookOrderController {
    @FXML
    private Button orderButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Text addingMessage;
    @FXML
    private TextField titleField;
    @FXML
    private TextField quantityField;

    @FXML
    public void handleOrderingAction() {
        OrderBookService.addOrder("", titleField.getText(), "In actualizare", quantityField.getText(), "-");
        System.out.println("book was succesfully ordered");
        backToHomePageForm();
    }
    @FXML
    public void backToHomePageForm() {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("homePage.fxml")));
            Stage registerStage = (Stage) orderButton.getScene().getWindow();
            registerStage.setTitle("Home Page");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            addingMessage.setText("error");
        }
    }

    @FXML
    public void cancelButtonOnAction() {
        backToBookshopsPageForm();
    }

    @FXML
    public void backToBookshopsPageForm() {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("booksList.fxml")));
            Stage registerStage = (Stage) cancelButton.getScene().getWindow();
            registerStage.setTitle("Home Page");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            addingMessage.setText("error");
        }
    }


}
