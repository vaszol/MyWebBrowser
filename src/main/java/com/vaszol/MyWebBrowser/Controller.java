package com.vaszol.MyWebBrowser;

import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * <h>контроллер для панели с веб-страницей</h>
 */
public class Controller implements Initializable {
    @FXML
    private TextField textField;
    @FXML
    private WebView webView;
    @FXML
    private Label label;
    private WebEngine engine;
    private Tab tab;
    private URL url;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        engine = webView.getEngine();
        textField.setText("https://www.google.com");
        engine.load(textField.getText());
        engine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == Worker.State.RUNNING) {
                textField.setText(engine.getLocation());
                try {
                    url = new URL(engine.getLocation());
                    tab.setText(url.getHost());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                System.out.println("called");
            }
        });
    }

    public void btn1(ActionEvent event) {
        label.setText(textField.getText());
        try {
            url = new URL(textField.getText());
            System.out.println(url.toString());
            tab.setText(url.getHost());
            engine.load(url.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void setOnClosed() {
        System.out.println("setOnClosed");
    }

    public void setTab(Tab tab) {
        this.tab = tab;
    }
}
