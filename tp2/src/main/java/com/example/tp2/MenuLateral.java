package com.example.tp2;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuLateral extends VBox {

    public MenuLateral(MainView mainView) {

        Button accueil = new Button("Accueil");
        Button regles = new Button("Règles");
        Button jouer = new Button("Jouer");
        Button quitter = new Button("Quitter");

        accueil.setOnAction(e -> mainView.afficherAccueil());
        regles.setOnAction(e -> mainView.afficherRegles());
        jouer.setOnAction(e -> mainView.afficherJeu());
        quitter.setOnAction(e -> System.exit(0));

        this.getChildren().addAll(accueil, regles, jouer, quitter);
        this.setSpacing(10);
        this.setPrefWidth(150);
    }
}