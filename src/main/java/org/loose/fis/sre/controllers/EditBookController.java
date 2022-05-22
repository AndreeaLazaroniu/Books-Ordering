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

import java.io.IOException;

public class EditBookController {
    @FXML
    private Text errorMessage;
    @FXML
    private TextField titleField;
    @FXML
    private TextField priceField;
    @FXML
    private Button cancelButton;
    @FXML
    private Button doneButton;

    @FXML
    public void cancelButtonOnAction()
    {
        backToListBooksForm();
    }

    @FXML
    public void backToListBooksForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("listBooks.fxml"));
            Stage registerStage = (Stage) cancelButton.getScene().getWindow();
            registerStage.setTitle("List of Books");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            errorMessage.setText("error");
        }
    }


    @FXML
    public void handleEditingAction() {
        BookService.editBook(titleField.getText(), priceField.getText());
        backToListBooksForm2();
    }

    @FXML
    public void backToListBooksForm2() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("listBooks.fxml"));
            Stage registerStage = (Stage) doneButton.getScene().getWindow();
            registerStage.setTitle("List of Books");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            errorMessage.setText("error");
        }
    }
}

