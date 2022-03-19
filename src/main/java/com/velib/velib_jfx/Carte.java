package com.velib.velib_jfx;

import java.util.ArrayList;

public class Carte {
    public ArrayList<Station> mesStations;

    public Carte() {
        mesStations = new ArrayList<Station>();
    }

    public void ajouteStation(String codeStation, String name, String arrondissement, String bonus, String is_renting, int capacite, int velo_disp, int emplacement_disp) {
        mesStations.add(new Station(codeStation, name, arrondissement, bonus, is_renting, capacite, velo_disp, emplacement_disp));
    }

    public Station chercher(String station) {
        for (Station s : mesStations) {
            if (station.equals(s.getNumero())) {
                return s;
            }
        }

        return null;
    }

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