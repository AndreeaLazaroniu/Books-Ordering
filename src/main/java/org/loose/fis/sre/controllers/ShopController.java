package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import java.net.URL;

public class ShopController implements Initializable{

    @FXML
    private Button cancelButton;
    @FXML
    private Button booksButton;
    @FXML
    private Button ordersButton;
    @FXML
    private ImageView shopImageView;
    @FXML
    private ImageView booksImageView;
    @FXML
    private ImageView ordersImageView;
    @FXML
    private Text errorMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File shopFile = new File("images/bookshop.jpg");
        Image shopImage = new Image(shopFile.toURI().toString());
        shopImageView.setImage(shopImage);

        File booksFile = new File("images/books.jpg");
        Image booksImage = new Image(booksFile.toURI().toString());
        booksImageView.setImage(booksImage);

        File ordersFile = new File("images/orders.jpg");
        Image ordersImage = new Image(ordersFile.toURI().toString());
        ordersImageView.setImage(ordersImage);
    }

    @FXML
    public void cancelButtonOnAction()
    {
        createLoginForm();
    }

    @FXML
    public void createLoginForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
            Stage registerStage = (Stage) cancelButton.getScene().getWindow();
            registerStage.setTitle("Login");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            errorMessage.setText("error");
        }
    }

    @FXML
    public void booksButtonOnAction()
    {
        bookListForm();
    }

    @FXML
    public void bookListForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("listBooks.fxml"));
            Stage registerStage = (Stage) booksButton.getScene().getWindow();
            registerStage.setTitle("List of books");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            errorMessage.setText("error");
        }
    }

    @FXML
    public void ordersButtonOnAction()
    {
        orderListForm();
    }

    @FXML
    public void orderListForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("listOrders.fxml"));
            Stage registerStage = (Stage) ordersButton.getScene().getWindow();
            registerStage.setTitle("List of orders");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            errorMessage.setText("error");
        }
    }
}
