package com.example.javachatwindow.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatController {
    @FXML
    private TextArea chatArea;
    @FXML
    private TextField chatInput;

    public ChatController() {
    }

    public void clickSentButton(ActionEvent actionEvent) {
        final String text = chatInput.getText();
        chatArea.appendText(text + "\n");
        chatInput.setText("");
        if (text.isBlank()) {
            return;


        }
    }
}