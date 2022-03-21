package com.velib.velib_jfx;

import java.util.ArrayList;

public class Carte {

    // Déclaration des variables
    public ArrayList<Station> mesStations;

    // Instanciation du tableau comportant toutes les stations
    public Carte() {
        mesStations = new ArrayList<Station>();
    }

    public void ajouteStation(String codeStation, String name, String arrondissement, String bonus, String is_installed, int capacite, int emplacement_disp, int velo_disp, String date) {
        mesStations.add(new Station(codeStation, name, arrondissement, bonus, is_installed, capacite, emplacement_disp, velo_disp, date));
    }

    /**
     *  Cette fonction retourne les informations d'une station recherchée avec son nom.
     *  pour l'appeler il faudrait faire carte.chercher("Brancion - Lefebvre");
     * @param station est le nom de la station recherchée
     * @return s, ici on retourne les informations.
     */
    public Station chercher(String station) {
        for (Station s : mesStations) {
            if (station.equals(s.getNumero())) {
                return s;
            }
        }

        return null;
    }


    /**
     * Permet l'affichage des infos du numéro de station demandé dans les paramètres
     * @param identifiant est le code de la station
     * @return les informations du numéro de la station
     */
    public Station getLaStation(int identifiant) {
        return mesStations.get(identifiant);
    }

    public int nbStations() {
        return mesStations.size();
    }

    public ArrayList<Station> getMesStations() {
        return mesStations;
    }
}