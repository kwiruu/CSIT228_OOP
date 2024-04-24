package com.example.csit228_f1_v2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        CreateTable.createuserTable();
        CreateTable.createUserTable();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);

        Text txtWelcome = new Text("Welcome to CIT");
        txtWelcome.setFont(Font.font("Chiller", FontWeight.EXTRA_BOLD, 69));
        txtWelcome.setFill(Color.RED);
        txtWelcome.setTextAlignment(TextAlignment.CENTER);
        grid.add(txtWelcome, 0, 0, 2, 1);

        Label lbRegister = new Label("Register:");
        lbRegister.setFont(Font.font(30));
        lbRegister.setTextFill(Color.LIGHTSKYBLUE);
        grid.add(lbRegister, 0, 1);

        Label lbUsername = new Label("Username: ");
        lbUsername.setTextFill(Color.LIGHTSKYBLUE);
        lbUsername.setFont(Font.font(20));
        grid.add(lbUsername, 0, 2);

        TextField tfUsername = new TextField();
        grid.add(tfUsername, 1, 2);

        Label lbEmail = new Label("Email: ");
        lbEmail.setTextFill(Color.LIGHTSKYBLUE);
        lbEmail.setFont(Font.font(20));
        grid.add(lbEmail, 0, 3);

        TextField tfEmail = new TextField();
        grid.add(tfEmail, 1, 3);

        Label lbPassword = new Label("Password: ");
        lbPassword.setTextFill(Color.LIGHTSKYBLUE);
        lbPassword.setFont(Font.font(20));
        grid.add(lbPassword, 0, 4);

        PasswordField pfPassword = new PasswordField();
        grid.add(pfPassword, 1, 4);

        Button btnRegister = new Button("Register");
        btnRegister.setFont(Font.font(20));
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btnRegister);
        grid.add(hbBtn, 1, 5);

        Button btnLogIn = new Button("Log In Instead");
        btnLogIn.setFont(Font.font(20));
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(btnLogIn);
        grid.add(hbBtn2, 1, 6);

        btnLogIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Parent loginRoot = FXMLLoader.load(getClass().getResource("login-view.fxml"));
                    Scene loginScene = new Scene(loginRoot);
                    stage.setScene(loginScene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String username = tfUsername.getText();
                String email = tfEmail.getText();
                String password = pfPassword.getText();

                try (Connection c = MySQLConnection.getConnection()) {
                    // Insert user into tblaccounts
                    String accountsQuery = "INSERT INTO tblaccounts(name, email, address) VALUES(?,?,?)";
                    try (PreparedStatement accountsStatement = c.prepareStatement(accountsQuery, Statement.RETURN_GENERATED_KEYS)) {
                        accountsStatement.setString(1, username);
                        accountsStatement.setString(2, email);
                        accountsStatement.setString(3,"");
                        int accountsRowsInserted = accountsStatement.executeUpdate();
                        System.out.println("Rows inserted into tblaccounts: " + accountsRowsInserted);

                        // Retrieve the auto-generated ID from tblaccounts
                        ResultSet generatedKeys = accountsStatement.getGeneratedKeys();
                        int userId = -1;
                        if (generatedKeys.next()) {
                            userId = generatedKeys.getInt(1);
                        } else {
                            throw new SQLException("Failed to get generated user ID.");
                        }

                        // Insert user into tblusers
                        String usersQuery = "INSERT INTO tblusers(username, password, id_fk) VALUES(?,?,?)";
                        try (PreparedStatement usersStatement = c.prepareStatement(usersQuery)) {
                            usersStatement.setString(1, username);
                            usersStatement.setString(2, password);
                            usersStatement.setInt(3, userId);
                            int usersRowsInserted = usersStatement.executeUpdate();
                            System.out.println("Rows inserted into tblusers: " + usersRowsInserted);
                        }
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Registration: Username - " + username + ", Email - " + email + ", Password - " + password);
            }
        });


        Scene scene = new Scene(grid, 700, 500, Color.BLACK);
        stage.setScene(scene);
        scene.setFill(Color.CORNFLOWERBLUE);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
