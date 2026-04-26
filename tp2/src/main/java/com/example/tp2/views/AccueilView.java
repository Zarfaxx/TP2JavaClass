package com.example.tp2.views;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

// Class pour le menu principale
public class AccueilView extends StackPane {

    public AccueilView() {

        // Background image
        ImageView image = new ImageView(
                new Image(getClass().getResource("/board.png").toExternalForm())
        );

        image.setFitWidth(800);
        image.setPreserveRatio(true);

        // Titre
        Label title = new Label("Jeu Serpents et Échelles");
        title.setStyle(
                "-fx-font-size: 32px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-color: rgba(0,0,0,0.5);" +
                        "-fx-padding: 10px 20px;" +
                        "-fx-background-radius: 10px;"
        );

        // Container pour le title (top-centered)
        VBox overlay = new VBox(title);
        overlay.setAlignment(Pos.TOP_CENTER);
        overlay.setPickOnBounds(false); // allows clicks through if needed
        overlay.setSpacing(20);

        // Ajouter tout au StackPane
        this.getChildren().addAll(image, overlay);
    }
}