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

import static org.loose.fis.sre.services.UserService.doesCredsMatchForLogin;
import static org.loose.fis.sre.services.UserService.checkRole;

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
    public void cancelButtonOnAction(ActionEvent event)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void handleLoginAction() {
        if(!usernameField.getText().isEmpty() && !passwordField.getText().isEmpty())
        {
            if (UserService.doesCredsMatchForLogin(usernameField.getText())) {
                if (UserService.checkRole(usernameField.getText()))
                {
                    System.out.println("Authentication succesfully");
                    validateLogin();
                } else
                {
                    createAccountForm();
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
    public void createAccountForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("register.fxml")));
            Stage registerStage = (Stage) loginButton.getScene().getWindow();
            registerStage.setTitle("Register");
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
}

