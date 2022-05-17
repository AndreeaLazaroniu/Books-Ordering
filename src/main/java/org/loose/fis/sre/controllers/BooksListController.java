package org.loose.fis.sre.controllers;

//import javafx.collections.FXCollections;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
//import javafx.collections.ObservableList;
//import javafx.scene.layout.VBox;


import org.loose.fis.sre.services.BookService;
import org.loose.fis.sre.model.Book;

//import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class BooksListController implements Initializable {
    @FXML
    private TextField filterField;

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
    private Button cancelButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button orderButton;

    @FXML
    private Text errorMessage;

    @FXML
    private TextField searchBar;

    private final ObservableList<Book> masterData = FXCollections.observableArrayList();
    private final ObservableList<Book> filteredData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        pageNumber.setCellValueFactory(new PropertyValueFactory<>("pageNumber"));
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));

        table.setItems(BookService.getBooks());
        //masterData = table.getItems();
        System.out.println("Initial masterData = " + masterData);

        filterField.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {

                updateFilteredData();
            }
        });
        System.out.println("Initial filteredData -> masterData = " + filteredData);
    }
    @FXML
    private void updateFilteredData() {
        System.out.println("updateFilteredData() -> filteredData = " + filteredData);
        filteredData.clear();
        System.out.println("updateFilteredData() -> masterData = " + masterData);
        for (Book book : masterData) {
            if (matchesFilter(book)) {
                filteredData.add(book);
            }
        }

        reapplyTableSortOrder();
    }
    @FXML
    private boolean matchesFilter(Book book) {
        String filterString = filterField.getText();
        if (filterString == null || filterString.isEmpty()) {
            return true;
        }

        String lowerCaseFilterString = filterString.toLowerCase();

        if (book.getTitle().toLowerCase().contains(lowerCaseFilterString)) {
            return true;
        } else return book.getAuthor().toLowerCase().contains(lowerCaseFilterString);// Does not match
    }
    @FXML
    private void reapplyTableSortOrder() {
        ArrayList<TableColumn<Book, ?>> sortOrder = new ArrayList<>(table.getSortOrder());
        table.getSortOrder().clear();
        table.getSortOrder().addAll(sortOrder);
    }


    @FXML
    public void cancelButtonOnAction()
    {
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
        }catch(IOException e)
        {
            errorMessage.setText("error");
        }
    }
}
