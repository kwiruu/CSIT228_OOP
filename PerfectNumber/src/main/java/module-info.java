module org.example.perfectnumber {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.perfectnumber to javafx.fxml;
    exports org.example.perfectnumber;
}