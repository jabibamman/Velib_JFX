package com.velib.velib_jfx;

import eu.bitm.NominatimReverseGeocoding.NominatimReverseGeocodingJAPI;




public class Station {
    // Déclaration des variables
    private String nom, numero, cbDispo, ouvert, arrondissement, date, coordinates, adresse;
    private int capacite, velo_disp, emplacement_disp;

    // Constructeur
    public Station(String numero, String nom, String arrondissement, String cbDispo, String ouvert, int capacite, int emplacement_disp, int velo_disp, String date, String coordinates) {
        this.numero = numero;
        this.nom = nom;
        this.arrondissement = arrondissement;
        this.cbDispo = cbDispo;
        this.ouvert = ouvert;
        this.capacite = capacite;
        this.velo_disp = velo_disp;
        this.emplacement_disp = emplacement_disp;
        this.date = date;
        this.coordinates = coordinates;
        this.adresse = getCoordinates();

    }

    // Getters
    public String getNom()  {
        try {
            return nom;
            // Si le nom est null, on renvoie un message d'erreur
        } catch (NullPointerException e) {

            return "";
        }
    }

    public String getArrondissement() {
        return arrondissement;
    }

    public String getCbDispo() {
        return cbDispo;
    }

    public String getNumero() {
        return numero;
    }

    public String isOuvert() {
        return ouvert;
    }

    public int getCapacite() {
        return capacite;
    }

    public int getVelo_disp() {
        return velo_disp;
    }

    public int getEmplacement_disp() {
        return emplacement_disp;
    }

    public String getDate() {
        // date.replaceAll("T", " à ") pour mieux formater la date, date.length()-4 pour supprimer le "+00:00" à la fin de la date
        return date.replaceAll("T", " à ").substring(0, date.length()-4);
    }

    public String getCoordinates() {

        coordinates = coordinates.replaceAll("\\[", "").replaceAll("\\]", "");

        return coordinates;
    }


    public String getAdresse() {
        NominatimReverseGeocodingJAPI nominatim1 = new NominatimReverseGeocodingJAPI(); //create instance with default zoom level (18)

        String[] coord = adresse.split(",");

        adresse = String.valueOf(nominatim1.getAdress(Double.parseDouble(coord[1]),Double.parseDouble(coord[0]))); //returns Address object for the given position


        return adresse;

    }

    @Override
    // Méthode toString
    public String toString() {
        return "Station{" +
                "nom='" + nom + '\'' +
                ", numero='" + numero + '\'' +
                ", cbDispo='" + cbDispo + '\'' +
                ", ouvert='" + ouvert + '\'' +
                ", arrondissement='" + arrondissement + '\'' +
                ", date='" + date + '\'' +
                ", capacite=" + capacite +
                ", velo_disp=" + velo_disp +
                ", emplacement_disp=" + emplacement_disp +
                ", coordinates='" + coordinates + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}

