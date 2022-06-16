module com.example.javachatwindow {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javachatwindow to javafx.fxml;
    exports com.example.javachatwindow.client;
    opens com.example.javachatwindow.client to javafx.fxml;
}