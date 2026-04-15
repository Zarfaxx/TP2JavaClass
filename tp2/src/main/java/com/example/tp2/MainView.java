package com.example.tp2;

import com.example.tp2.views.*;
import javafx.scene.layout.BorderPane;

public class MainView extends BorderPane {

    public MainView() {
        this.setLeft(new MenuLateral(this));
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
}