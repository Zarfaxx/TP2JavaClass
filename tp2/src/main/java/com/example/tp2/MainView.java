package com.example.tp2;

import com.example.tp2.views.*;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

//Class pour prendre en charge le changement de scene
public class MainView extends BorderPane {

    public MainView() {
        this.setLeft(new MenuLateral(this));
        this.setTop(createMenuBar());
        afficherAccueil();
    }

    public void afficherAccueil() {
        this.setCenter(new AccueilView());
    }

    public void afficherRegles() {
        this.setCenter(new ReglesView());
    }

    public void afficherJeu() {
        this.setCenter(new JeuView());
    }

    private MenuBar createMenuBar() {
        Menu jeu = new Menu("Jeu");

        MenuItem recommencer = new MenuItem("Recommencer");
        MenuItem quitter = new MenuItem("Quitter");

        recommencer.setOnAction(e -> afficherJeu());
        quitter.setOnAction(e -> afficherAccueil());

        jeu.getItems().addAll(recommencer, quitter);

        return new MenuBar(jeu);
    }
}