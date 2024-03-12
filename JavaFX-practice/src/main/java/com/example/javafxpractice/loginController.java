package com.example.javafxpractice;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class loginController {
    @FXML
    private Parent helloview;
    @FXML
    private GridPane pnLogin;

    @FXML
    private VBox pnview;

    @FXML
    private AnchorPane loginview;
    @FXML
    private Label welcomeText;
    @FXML
    private TextField usernameField_input;
    @FXML
    private PasswordField passField_input;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        Parent helloview = FXMLLoader.load(helloApplication.class.getResource("hello-view.fxml"));



        welcomeText.setText("Sign in button pressed");

        if(usernameField_input.getText().toString().equals("keiru277") && passField_input.getText().toString().equals("12345") ||
                usernameField_input.getText().toString().equals("keiru") && passField_input.getText().toString().equals("123") ||
                usernameField_input.getText().toString().equals("valceven") && passField_input.getText().toString().equals("123")) {
            AnchorPane p = (AnchorPane) pnLogin.getParent();
            loginview.getScene().getStylesheets().clear();
            loginview.getScene().getStylesheets().add(getClass().getResource("hello.css").toExternalForm());
            p.getChildren().remove(pnLogin);
            p.getChildren().add(helloview);
        }
        else{
            welcomeText.setText("Invalid");
        }
    }
}