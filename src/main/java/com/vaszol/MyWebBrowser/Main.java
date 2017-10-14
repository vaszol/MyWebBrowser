package com.vaszol.MyWebBrowser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("resource = " + getClass().getResource("/"));
        Parent root = FXMLLoader.load(getClass().getResource("/rootScene.fxml"));
        primaryStage.setTitle("My Super Brouoser");
        Scene scene = new Scene(root);
        primaryStage.setMinHeight(480);
        primaryStage.setMinWidth(320);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
