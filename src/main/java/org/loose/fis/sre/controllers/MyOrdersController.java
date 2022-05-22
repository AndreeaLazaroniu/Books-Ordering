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



import org.loose.fis.sre.services.OrderBookService;
import org.loose.fis.sre.model.OrderBook;


import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MyOrdersController implements Initializable {
    @FXML
    private TableView<OrderBook> table;

    @FXML
    private TableColumn<OrderBook, String> time;

    @FXML
    private TableColumn<OrderBook, String> status;

    @FXML
    private TableColumn<OrderBook, String> total;

    @FXML
    private TableColumn<OrderBook, String> orderedBook;

    @FXML
    private Button cancelButton;

    @FXML
    private Button refreshButton;

    @FXML
    private Text errorMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderedBook.setCellValueFactory(new PropertyValueFactory<>("orderedBook"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));

        table.setItems(OrderBookService.getOrdersCustomer(LoginController.usernameCurrent));
    }

    @FXML
    public void cancelButtonOnAction() {
        backToHomePageForm();
    }

    @FXML
    public void backToHomePageForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("homePage.fxml")));
            Stage registerStage = (Stage) cancelButton.getScene().getWindow();
            registerStage.setTitle("Home Page");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        } catch (IOException e) {
            errorMessage.setText("error");
        }
    }

    @FXML
    public void refreshButtonOnAction() {
        refreshPageForm();
    }

    @FXML
    public void refreshPageForm() {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("myOrders.fxml")));
            Stage registerStage = (Stage) refreshButton.getScene().getWindow();
            registerStage.setTitle("My Orders Page");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        } catch (IOException e) {
            errorMessage.setText("error");
        }
    }
}
