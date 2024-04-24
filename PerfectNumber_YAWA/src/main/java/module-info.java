module org.example.perfectnumber_yawa {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.perfectnumber_yawa to javafx.fxml;
    exports org.example.perfectnumber_yawa;
}