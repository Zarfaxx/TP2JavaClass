package com.example.tp2.model;

import java.util.HashMap;
import java.util.Map;

//Class pour prendre en charge l'affichage de la grille
public class Grille {

    private Map<Integer, Integer> echelles = new HashMap<>();
    private Map<Integer, Integer> serpents = new HashMap<>();

    private Map<Integer, Integer> numeroEchelles = new HashMap<>();
    private Map<Integer, Integer> numeroSerpents = new HashMap<>();

    public Grille() {
        initialiserMecanismes();
    }

    //Fonction pour preparer les echelle et les serpents
    private void initialiserMecanismes() {

        // Echelle static sure la grille
        ajouterEchelle(1, 3, 22);
        ajouterEchelle(2, 5, 8);
        ajouterEchelle(3, 11, 26);
        ajouterEchelle(4, 20, 29);
        ajouterEchelle(5, 27, 44);
        ajouterEchelle(6, 36, 55);
        ajouterEchelle(7, 51, 67);
        ajouterEchelle(8, 71, 92);

        // Serpents static sure la grille
        ajouterSerpent(1, 17, 4);
        ajouterSerpent(2, 19, 7);
        ajouterSerpent(3, 21, 9);
        ajouterSerpent(4, 43, 34);
        ajouterSerpent(5, 62, 18);
        ajouterSerpent(6, 64, 60);
        ajouterSerpent(7, 87, 24);
        ajouterSerpent(8, 95, 75);
    }

    //Fonction pour ajouter une echelle au jeu
    private void ajouterEchelle(int numero, int bas, int haut) {
        echelles.put(bas, haut);
        numeroEchelles.put(bas, numero);
        numeroEchelles.put(haut, numero);
    }

    //Fonction pour ajouter un serpent au jeu
    private void ajouterSerpent(int numero, int tete, int queue) {
        serpents.put(tete, queue);
        numeroSerpents.put(tete, numero);
        numeroSerpents.put(queue, numero);
    }

    public Map<Integer, Integer> getEchelles() {
        return echelles;
    }

    public Map<Integer, Integer> getSerpents() {
        return serpents;
    }

    public Map<Integer, Integer> getNumeroEchelles() {
        return numeroEchelles;
    }

    public Map<Integer, Integer> getNumeroSerpents() {
        return numeroSerpents;
    }
}