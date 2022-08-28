module com.example.javachatwindow {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports com.example.javachatwindow.client;
    opens com.example.javachatwindow.client to javafx.fxml;
}
