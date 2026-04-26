/*
Serpent et Echelle
Philip G. Thoms
Tp2 pour le cours de programmation d'environnements graphiques
Jeu de serpents et echelles avec des changements de scene et l'utilisation d'images
*/
package com.example.tp2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Class pour initialiser le meny principale
public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new MainView(), 1200, 1000);
        stage.setMinWidth(1100);
        stage.setMinHeight(900);

        stage.setTitle("Serpents et Échelles");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}