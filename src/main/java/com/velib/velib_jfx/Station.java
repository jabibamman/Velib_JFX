package com.velib.velib_jfx;

public class Station extends Carte {
    private String nom, numero, bonus, ouvert, arrondissement;

    public Station(String numero, String nom, String arrondissement, String bonus, String ouvert) {
        this.numero = numero;
        this.nom = nom;
        this.arrondissement = arrondissement;
        this.bonus = bonus;
        this.ouvert = ouvert;
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
