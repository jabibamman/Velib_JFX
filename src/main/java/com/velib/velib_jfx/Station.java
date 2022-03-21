package com.velib.velib_jfx;

public class Station extends Carte {
    private String nom, numero, bonus, ouvert, arrondissement, date;
    private int capacite, velo_disp, emplacement_disp;

    public Station(String numero, String nom, String arrondissement, String bonus, String ouvert, int capacite, int emplacement_disp, int velo_disp, String date) {
        this.numero = numero;
        this.nom = nom;
        this.arrondissement = arrondissement;
        this.bonus = bonus;
        this.ouvert = ouvert;
        this.capacite = capacite;
        this.velo_disp = velo_disp;
        this.emplacement_disp = emplacement_disp;
        this.date = date;

    }

    public String getNom() {
        return nom;
    }

    public String getArrondissement() {
        return arrondissement;
    }

    public String getBonus() {
        return bonus;
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
        date = date.replaceAll("T", " à ");

        // date.length()-6 pour supprimer le "+00:00" à la fin de la date
        return date;
    }

    @Override
    public String toString() {
        return "Station{" +
                "nom='" + nom + '\'' +
                ", numero='" + numero + '\'' +
                ", arrondissement='" + arrondissement + '\'' +
                ", bonus=" + bonus +
                ", ouvert=" + ouvert +
                '}';
    }
}
