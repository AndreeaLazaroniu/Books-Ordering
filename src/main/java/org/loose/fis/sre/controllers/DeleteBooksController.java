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

public class DeleteBooksController {
    @FXML
    private Text errorMessage;
    @FXML
    private TextField titleField;
    @FXML
    private Button cancelButton;
    @FXML
    private Button deleteButton;

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
    public void handleDeletingAction() {
        BookService.deleteBook(titleField.getText());
        backToListBooksForm2();
    }

    @FXML
    public void backToListBooksForm2() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("listBooks.fxml"));
            Stage registerStage = (Stage) deleteButton.getScene().getWindow();
            registerStage.setTitle("List of Books");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            errorMessage.setText("error");
        }
    }
}
