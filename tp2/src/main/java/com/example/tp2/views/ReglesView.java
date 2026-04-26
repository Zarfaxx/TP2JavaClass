package com.example.tp2.views;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

//Class pour la page des regles
public class ReglesView extends StackPane {

    public ReglesView() {
        Label regles = new Label(
                "Règles:\n\n" +
                        "- Lancez le dé\n" +
                        "- Avancez selon le résultat\n" +
                        "- Montez les échelles\n" +
                        "- Descendez les serpents\n" +
                        "- Premier à 100 gagne"
        );

        regles.setStyle("-fx-font-size: 16px;");

        this.getChildren().add(regles);
    }
}