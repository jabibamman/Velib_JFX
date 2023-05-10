package com.velib.velib_jfx;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class JPasserelle {
    // Déclaration des variables
    private static String url;
    private static final Carte c = new Carte();

    public static Carte getCarte() {
        // Initialisation des variables...
        String num_adresse = null;

        try {
            String url = "https://opendata.paris.fr/api/records/1.0/search/?dataset=velib-disponibilite-en-temps-reel&q=&rows=-1&sort=name&facet=name&facet=is_installed&facet=is_renting&facet=is_returning&facet=nom_arrondissement_communes&facet=stationcode";
            InputStream lien = new URL(url).openStream();
            BufferedReader fichier = new BufferedReader(new InputStreamReader(lien, StandardCharsets.UTF_8));

            JSONObject json = new JSONObject(fichier.readLine());
            fichier.close();

            JSONArray data = json.getJSONArray("records");

            // On parcourt les la listes des enregistrements des stations
            for (int i = 0; i < json.getInt("nhits"); i++) {
                JSONObject js = data.getJSONObject(i);
                JSONObject fields = js.getJSONObject("fields");
                JSONObject geometry = js.getJSONObject("geometry");

                // On annonce bien ici que les variables récupéré depuis le JSON sont en String (cast)
                String stationcode = fields.getString("stationcode");

                // Switch qui va permettre d'affecter le n° d'arrondissement
                switch (stationcode.charAt(0)) {
                    // Stations de Paris (tout arrondissement confondu)
                    case '1':
                        // La longueur du code de la station doit être ≤ 4, car on cherche que le 1er arrondissement il est donc égal à 4 de longueur...
                        if (stationcode.length() <= 4) {
                            num_adresse = stationcode.substring(0, 1);
                        // Les stations supérieures à 4 de longueur sont les autres arrondissements
                        } else {
                            num_adresse = stationcode.substring(0, 2);
                        }
                        break;

                    case '2':
                        // Stations du 92
                        if (!Objects.equals(fields.get("nom_arrondissement_communes"), "Paris")) {
                            num_adresse = "92";
                        // Stations du 2ᵉ arrondissement
                        } else if (stationcode.length() <= 4) {
                            num_adresse = stationcode.substring(0, 1);
                        // Stations du 20ᵉ arrondissements
                        } else {
                            num_adresse = stationcode.substring(0, 2);
                        }
                        break;

                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        // Stations du n° arrondissement
                        if (stationcode.length() <= 4) {
                            // Les stations 9001 et 9002 sont en fait des stations du dixième arrondissements, j'ai donc réalisé la condition pour les remettre à leurs places.
                            if (stationcode.substring(0, 4).equals("9001") || stationcode.substring(0, 4).equals("9002")) {
                                num_adresse = "10";
                            } else {
                                num_adresse = stationcode.substring(0, 1);
                            }

                            // Stations de région (idf)
                        } else {
                            // Cette condition permet de retourner les stations mobiles du 92 et sinon elle affiche toutes les stations dans les départements
                            if (stationcode.substring(0, 2).equals("92")) {
                                // Mobile 92 (stationcode.substring(0, 2))
                                num_adresse = "mobile";
                            } else {
                                num_adresse = "9" + stationcode.charAt(0);
                            }
                            // System.out.println(num_adresse + " : " + fields.get("nom_arrondissement_communes") + ", stationCode : " + fields.get("stationcode")); // DEBUG pour voir si c'est les bonnes stations d'affichées
                        }
                        break;

                    default:
                        System.err.println("Mauvais Code de velib.Station : " + fields.get("stationcode"));
                        break;
                }

                // À chaque tour de boucle on insère la station qui a pour index la variable i
                c.ajouteStation(stationcode, fields.getString("name"), num_adresse, fields.getString("is_renting"), fields.getString("is_installed"), fields.getInt("capacity"), fields.getInt("numdocksavailable"), fields.getInt("numbikesavailable"), fields.getString("duedate"), String.valueOf(geometry.getJSONArray("coordinates")));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Erreur : le fichier n'existe pas !\n" + e);
        } catch (IOException e) {
            System.err.println("Erreur : \n" + e);
        }
        return c;
    }
}

