package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;

public class RegistrationController {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private ChoiceBox role;
    @FXML
    private Button cancelButton;
    @FXML
    private Button registerButton;


    @FXML
    public void initialize() {
        role.getItems().addAll("Customer", "BookShop Manager");
    }

    @FXML
    public void cancelButtonOnAction()
    {
        createLoginForm();
    }

    @FXML
    public void handleRegisterAction() {
        if(!usernameField.getText().isEmpty() && !passwordField.getText().isEmpty() && !addressField.getText().isEmpty() && !phoneNumberField.getText().isEmpty() && role.getValue()!=null) {
            try {
                UserService.addUser(usernameField.getText(), passwordField.getText(), addressField.getText(), phoneNumberField.getText(), (String) role.getValue());
                registrationMessage.setText("Account successfully created!");
                createLoginForm();
            } catch (UsernameAlreadyExistsException e) {
                registrationMessage.setText(e.getMessage());
            }
        }else
        {
            registrationMessage.setText("Please complete registration fields!");
        }
    }

    @FXML
    public void createLoginForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
            Stage registerStage = (Stage) registerButton.getScene().getWindow();
            registerStage.setTitle("Login");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            registrationMessage.setText("error");
        }
    }
}
