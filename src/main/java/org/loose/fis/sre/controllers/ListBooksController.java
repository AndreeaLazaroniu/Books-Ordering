package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.loose.fis.sre.services.BookService;
import org.loose.fis.sre.model.Book;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListBooksController implements Initializable {
    @FXML
    private TableView<Book> table;

    @FXML
    private TableColumn<Book, String> title;

    @FXML
    private TableColumn<Book, String> author;

    @FXML
    private TableColumn<Book, String> price;

    @FXML
    private TableColumn<Book, String> pageNumber;

    @FXML
    private TableColumn<Book, String> genre;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Text errorMessage;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        pageNumber.setCellValueFactory(new PropertyValueFactory<>("pageNumber"));
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));

        table.setItems(BookService.getBooks());
    }

    @FXML
    public void cancelButtonOnAction()
    {
        backToShopForm();
    }

    @FXML
    public void backToShopForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("shop.fxml"));
            Stage registerStage = (Stage) cancelButton.getScene().getWindow();
            registerStage.setTitle("My Bookshop Page");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            errorMessage.setText("error");
        }
    }

    @FXML
    public void addButtonOnAction()
    {
        bookDetailsForm();
    }

    @FXML
    public void bookDetailsForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("bookDetails.fxml"));
            Stage registerStage = (Stage) addButton.getScene().getWindow();
            registerStage.setTitle("Book Details");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            errorMessage.setText("error");
        }
    }

}
