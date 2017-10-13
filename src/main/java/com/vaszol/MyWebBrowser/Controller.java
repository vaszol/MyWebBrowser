package com.vaszol.MyWebBrowser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField textField;
    @FXML
    private WebView webView;
    @FXML
    private Label label;
    private WebEngine engine;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        engine = webView.getEngine();
        textField.setText("https://www.google.com");
    }

    public void btn1(ActionEvent event) {
        label.setText(textField.getText());
        engine.load(textField.getText());
    }
}
