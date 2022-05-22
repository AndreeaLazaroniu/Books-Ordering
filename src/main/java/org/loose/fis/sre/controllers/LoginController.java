package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;
import java.util.Objects;

import static org.loose.fis.sre.services.UserService.*;
import static org.loose.fis.sre.services.UserService.returnUsernameCurrent;

public class LoginController {
    @FXML
    private Text loginMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;

    @FXML
    public void cancelButtonOnAction(ActionEvent event)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public static String usernameCurrent;

    @FXML
    public void handleLoginAction() {
        if(!usernameField.getText().isEmpty() && !passwordField.getText().isEmpty())
        {
            if (UserService.doesCredsMatchForLogin(usernameField.getText())) {
                if (UserService.checkRole(usernameField.getText()))
                {
                    System.out.println("Authentication succesfully");
                    usernameCurrent = returnUsernameCurrent(usernameField.getText());
                    validateLogin();
                } else
                {
                    createShopForm();
                }
            }
            else {
                loginMessage.setText("no entry matching this user");

            }
        }else
        {
            {
                loginMessage.setText("Please enter username and password");
            }
        }
    }

    @FXML
    public void validateLogin(){
        homePageView();
    }

    @FXML
    public void createShopForm() {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("shop.fxml"));
            Stage registerStage = (Stage) loginButton.getScene().getWindow();
            registerStage.setTitle("Shop");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            loginMessage.setText("error");
        }
    }

    @FXML
    public void homePageView() {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("homePage.fxml")));
            Stage registerStage = (Stage) loginButton.getScene().getWindow();
            registerStage.setTitle("Home Page");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            loginMessage.setText("error");
        }
    }

    @FXML
    public void registerButtonOnAction()
    {
        createRegisterForm();
    }

    @FXML
    public void createRegisterForm() {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
            Stage registerStage = (Stage) loginButton.getScene().getWindow();
            registerStage.setTitle("Register");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch(IOException e)
        {
            loginMessage.setText("error");
        }
    }
}

