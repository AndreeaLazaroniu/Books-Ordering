package org.loose.fis.sre.controllers;

//import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//import javafx.collections.ObservableList;
//import javafx.scene.layout.VBox;


import org.loose.fis.sre.services.OrderBookService;
import org.loose.fis.sre.model.OrderBook;

//import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListOrdersController implements Initializable {
    @FXML
    private TableView<OrderBook> table;

    @FXML
    private TableColumn<OrderBook, String> customerName;

    @FXML
    private TableColumn<OrderBook, String> status;

    @FXML
    private TableColumn<OrderBook, String> total;

    @FXML
    private TableColumn<OrderBook, String> time;

    @FXML
    private Button cancelButton;

    @FXML
    private Button actionButton;

    @FXML
    private Text errorMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));

        table.setItems(OrderBookService.getOrders());
    }

    @FXML
    public void cancelButtonOnAction() {
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
        } catch (IOException e) {
            errorMessage.setText("error");
        }
    }

    @FXML
    public void actionButtonOnAction() {setStatusForm(); }

    @FXML
    public void setStatusForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("statusOrder.fxml"));
            Stage registerStage = (Stage) actionButton.getScene().getWindow();
            registerStage.setTitle("Status");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            errorMessage.setText("error");
        }
    }
}

