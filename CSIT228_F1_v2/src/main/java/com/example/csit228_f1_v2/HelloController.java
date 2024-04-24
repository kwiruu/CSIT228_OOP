package com.example.csit228_f1_v2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HelloController {
    public GridPane pnLogin;
    public AnchorPane pnMain;
    public VBox pnHome;
    public TextField passwordF;
    public TextField usernameF;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onSigninClick() throws IOException {
        System.out.println("ni click");

        boolean iscorrect=false;

        try(Connection c = MySQLConnection.getConnection();
            Statement statement = c.createStatement()){
            String query = "SELECT * FROM tblusers";
            ResultSet res = statement.executeQuery(query);

            while(res.next()){
                String passowrd =  res.getString("password");
                String username = res.getString("username");
                System.out.println("PASSWORD: "+passowrd+"\nUSERNAME: "+username);
                if(username.equals(usernameF.getText()) && passowrd.equals(passwordF.getText())){
                    iscorrect = true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(iscorrect){
            Parent homeview = FXMLLoader.load(HelloApplication.class
                    .getResource("crud-view.fxml"));
            AnchorPane p = (AnchorPane) pnLogin.getParent();
            p.getChildren().remove(pnLogin);
            p.getChildren().add(homeview);
        }
        else {
            System.out.println("sayop");
        }
    }
}