module com.example.javachatwindow {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.javachatwindow.client;
    opens com.example.javachatwindow.client to javafx.fxml;
}
