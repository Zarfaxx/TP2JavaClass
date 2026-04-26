package com.example.tp2.model;

import com.example.tp2.model.Grille;

import java.util.Random;

//Class pour prendre en charge les tours de joueur et ordinateur
public class Mecanisme {

    private Grille grille;
    private int positionJoueur = 1;
    private int positionOrdinateur = 1;
    private Random random = new Random();

    //Fonction pour update la grille
    public Mecanisme(Grille grille) {
        this.grille = grille;
    }

    //Fonction pour lander le de, retournant un resultat de 1 a 6
    public int lancerDe() {
        return random.nextInt(6) + 1;
    }

    //Fonction pour deplacer le joueur
    public void deplacerJoueur(int de) {
        positionJoueur = deplacer(positionJoueur, de, "Joueur");
    }

    //Fonction pour deplacer l'ordinateur
    public void deplacerOrdinateur(int de) {
        positionOrdinateur = deplacer(positionOrdinateur, de, "Ordinateur");
    }

    //Fonction pour deplacer un pion
    private int deplacer(int position, int de, String nom) {

        int nouvellePosition = position + de;

        // Clamp to 100
        if (nouvellePosition >= 100) {
            nouvellePosition = 100;

            if (nom.equals("Joueur"))
                positionJoueur = 100;
            else
                positionOrdinateur = 100;

            return 100;
        }

        // Case occupée
        if (nouvellePosition == getPositionAdverse(nom)) {
            nouvellePosition++;
        }

        // Échelle
        if (grille.getEchelles().containsKey(nouvellePosition)) {
            nouvellePosition = grille.getEchelles().get(nouvellePosition);
        }

        // Serpent
        else if (grille.getSerpents().containsKey(nouvellePosition)) {
            nouvellePosition = grille.getSerpents().get(nouvellePosition);
        }

        if (nom.equals("Joueur"))
            positionJoueur = nouvellePosition;
        else
            positionOrdinateur = nouvellePosition;

        return nouvellePosition;
    }

    //Fonctions pour trouver la position des pions au cas ou le joueur et l'adversaire sont a la meme position
    private int getPositionAdverse(String nom) {
        return nom.equals("Joueur") ? positionOrdinateur : positionJoueur;
    }

    public int getPositionJoueur() {
        return positionJoueur;
    }

    public int getPositionOrdinateur() {
        return positionOrdinateur;
    }

    //Fonction pour verifier si un pion a gagner
    public boolean verifierVictoire() {
        if (positionJoueur >= 100) {
            System.out.println("Le joueur gagne !");
            return true;
        }
        if (positionOrdinateur >= 100) {
            System.out.println("L'ordinateur gagne !");
            return true;
        }
        return false;
    }
}