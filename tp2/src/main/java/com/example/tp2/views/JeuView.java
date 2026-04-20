package com.example.tp2.views;


import com.example.tp2.model.Grille;
import com.example.tp2.model.Mecanisme;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class JeuView extends BorderPane {

    private Grille grille;
    private Mecanisme mecanisme;

    private Label info;

    public JeuView() {
        grille = new Grille();
        mecanisme = new Mecanisme(grille);

        info = new Label("Tour du joueur");

        Button lancer = new Button("Lancer le dé");

        lancer.setOnAction(e -> {
            int de = mecanisme.lancerDe();
            mecanisme.deplacerJoueur(de);

            if (mecanisme.verifierVictoire()) {
                info.setText("Joueur gagne !");
                return;
            }

            int deAI = mecanisme.lancerDe();
            mecanisme.deplacerOrdinateur(deAI);

            if (mecanisme.verifierVictoire()) {
                info.setText("Ordinateur gagne !");
                return;
            }

            info.setText("Positions: J=" +
                    mecanisme.getPositionJoueur() +
                    " A=" +
                    mecanisme.getPositionOrdinateur());
        });

        BorderPane.setAlignment(info, Pos.CENTER);

        this.setTop(info);
        this.setRight(lancer);
    }

    public static class AccueilView extends StackPane {

        public AccueilView() {
            this.getChildren().add(new Label("Accueil - Serpents et Échelles"));
        }
    }
}