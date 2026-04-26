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

        // Échelles
        ajouterEchelle(1, 2, 23);
        ajouterEchelle(2, 8, 34);
        ajouterEchelle(3, 20, 77);
        ajouterEchelle(4, 32, 68);
        ajouterEchelle(5, 41, 79);
        ajouterEchelle(6, 74, 88);
        ajouterEchelle(7, 82, 100);
        ajouterEchelle(8, 85, 95);

        // Serpents
        ajouterSerpent(1, 29, 9);
        ajouterSerpent(2, 38, 15);
        ajouterSerpent(3, 47, 5);
        ajouterSerpent(4, 53, 33);
        ajouterSerpent(5, 62, 37);
        ajouterSerpent(6, 86, 54);
        ajouterSerpent(7, 92, 70);
        ajouterSerpent(8, 97, 25);
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