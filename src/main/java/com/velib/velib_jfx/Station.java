package com.velib.velib_jfx;

public class Station {
    // Déclaration des variables
    private String nom, numero, cbDispo, ouvert, arrondissement, date;
    private int capacite, velo_disp, emplacement_disp;

    // Constructeur
    public Station(String numero, String nom, String arrondissement, String cbDispo, String ouvert, int capacite, int emplacement_disp, int velo_disp, String date) {
        this.numero = numero;
        this.nom = nom;
        this.arrondissement = arrondissement;
        this.cbDispo = cbDispo;
        this.ouvert = ouvert;
        this.capacite = capacite;
        this.velo_disp = velo_disp;
        this.emplacement_disp = emplacement_disp;
        this.date = date;

    }

    // Getters
    public String getNom() {
        return nom;
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
                '}';
    }
}

