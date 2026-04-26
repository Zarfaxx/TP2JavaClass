package com.example.tp2;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

//Class pour afficher le meny de gauche qui laisse changer entre les scene
public class MenuLateral extends VBox {

    public MenuLateral(MainView mainView) {

        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);

        Button accueil = new Button("Accueil");
        Button regles = new Button("Règles");
        Button jouer = new Button("Jouer");
        Button quitter = new Button("Quitter");

        accueil.setOnAction(e -> mainView.afficherAccueil());
        regles.setOnAction(e -> mainView.afficherRegles());
        jouer.setOnAction(e -> mainView.afficherJeu());
        quitter.setOnAction(e -> System.exit(0));

        this.getChildren().addAll(accueil, regles, jouer, quitter);
    }
}