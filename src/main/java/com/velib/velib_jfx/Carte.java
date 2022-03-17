package com.velib.velib_jfx;

import java.util.ArrayList;

public class Carte {
    public ArrayList<Station> mesStations;

    public Carte() {
        mesStations = new ArrayList<Station>();
    }

    public void ajouteStation(String codeStation, String name, String arrondissement, String bonus, String is_renting) {
        mesStations.add(new Station(codeStation, name, arrondissement, bonus, is_renting));
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
}