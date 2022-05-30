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


    /**
     * Cette fonction retourne la date de màj de la station et les renvoie sous forme de String.
     *
     * @return date
     */
    public String getDate() {
        // date.replaceAll("T", " à ") pour mieux formater la date, date.length()-4 pour supprimer le "+00:00" à la fin de la date
        return date.replaceAll("T", " à ").substring(0, date.length() - 4);
    }

    /**
     * Cette fonction retourne les coordonnée de la station, et les renvoie sous forme de String
     *
     * @return coordinates
     */
    public String getCoordinates() {

        coordinates = coordinates.replaceAll("\\[", "").replaceAll("\\]", "");

        return coordinates;
    }


    /**
     * Cette fonction retourne l'adresse de la station grâce à ses coordonnées.
     * Elle n'est pas optimisée, elle est à refaire (surement changer de module)
     *
     * @return adresse
     */
    public String getAdresse() {
        NominatimReverseGeocodingJAPI nominatim = new NominatimReverseGeocodingJAPI();
        String[] coord = getCoordinates().split(",");
        adresse = String.valueOf(nominatim.getAdress(Double.parseDouble(coord[1]), Double.parseDouble(coord[0])));

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

