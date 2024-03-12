package com.example.javafxpractice;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;




public class helloController {
    @FXML
    private VBox pnHello;

    @FXML
    private Parent loginview;

    @FXML
    private ColorPicker cpPicker;

//    @FXML
//    protected void OnLogOutButtonClick() throws IOException{
//        Parent loginview = FXMLLoader.load(loginController.class.getResource("login-view.fxml"));
//        AnchorPane p = (AnchorPane) pnHello.getParent();
//        p.getChildren().remove(pnHello);
//        p.getChildren().add(loginview);
//    }

    @FXML
    protected void OnLogOutButtonClick() throws IOException{
        Parent loginview = FXMLLoader.load(loginController.class.getResource("login-view.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(getClass().getResource("hello.css").getPath()));
        bw.write(".root{ -fx-background-image: url(\"bg.jpg\"); }");
        bw.newLine();
        bw.write(".botton { -fx-background-color: #" + cpPicker.getValue().toString().substring(2, 8)+ "; }");
        bw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        AnchorPane p = (AnchorPane) pnHello.getParent();
        p.getChildren().remove(pnHello);
        p.getChildren().add(loginview);
    }


}
