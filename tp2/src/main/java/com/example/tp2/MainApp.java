package com.example.tp2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        MainView root = new MainView();

        Scene scene = new Scene(root, 1000, 650);

        stage.setTitle("Serpents et Échelles");
        stage.setScene(scene);

        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setMaxWidth(1200);
        stage.setMaxHeight(700);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}