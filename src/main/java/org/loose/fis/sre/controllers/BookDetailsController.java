package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.loose.fis.sre.exceptions.BookDoesntExistException;
import org.loose.fis.sre.exceptions.TitleAlreadyExistsException;
import org.loose.fis.sre.services.BookService;

import java.io.IOException;

public class BookDetailsController {

    @FXML
    private Text addingMessage;
    @FXML
    private Text errorMessage;
    @FXML
    private TextField titleField;
    @FXML
    private TextField authorField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField pageNumberField;
    @FXML
    private ChoiceBox genre;
    @FXML
    private Button cancelButton;
    @FXML
    private Button addingButton;

    @FXML
    public void initialize() {
        genre.getItems().addAll("Fantasy", "Romance", "Science Fiction", "History", "Biography", "Psychology", "Young Adult", "Mister", "Crime Novel");
    }

    @FXML
    public void backToListBooksForm2() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("listBooks.fxml"));
            Stage registerStage = (Stage) addingButton.getScene().getWindow();
            registerStage.setTitle("List of Books");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            addingMessage.setText("error");
        }
    }

    @FXML
    public void handleAddingAction() {
        try {
            BookService.addBook(titleField.getText(), authorField.getText(), priceField.getText(), pageNumberField.getText(), (String) genre.getValue());
            //addingMessage.setText("Book was added successfully!");
            backToListBooksForm2();
        } catch (TitleAlreadyExistsException e) {
            addingMessage.setText(e.getMessage());
        }

    }

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

    /*
    @FXML
    public void handleDeletingAction() {
        try {
            BookService.deleteBook(titleField.getText(), authorField.getText(), priceField.getText(), pageNumberField.getText(), (String) genre.getValue());
            addingMessage.setText("Book was deleted successfully!");
        } catch (BookDoesntExistException e) {
            addingMessage.setText(e.getMessage());
        }
    }
    */
}
