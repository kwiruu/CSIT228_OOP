module com.example.javafxpractice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxpractice to javafx.fxml;
    exports com.example.javafxpractice;
}