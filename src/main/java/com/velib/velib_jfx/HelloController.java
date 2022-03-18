package com.velib.velib_jfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    // Créations des variables
    Carte c;
    ObservableList<Station> list;
    @FXML
    Label date, v_dispo, nb_total_pAcces, etatStation, pointAttacheDispo, cb_dispo, adresse;
    @FXML
    TableColumn<Station, String> numStation, adresseTree, bonus, ouvert;
    @FXML
    TableView<Station> tableView;


    @Override
    // Cette fonction permet l'intialisation des Objets, un peu comme un Main
    public void initialize(URL url, ResourceBundle resourceBundle) {
        c = JPasserelle.getCarte();

        // On indique quel objet possède quel valeur dans la classe Station
        numStation.setCellValueFactory(new PropertyValueFactory<>("numero"));
        adresseTree.setCellValueFactory(new PropertyValueFactory<>("nom"));
        bonus.setCellValueFactory(new PropertyValueFactory<>("bonus"));
        ouvert.setCellValueFactory(new PropertyValueFactory<>("ouvert"));


        // Ici on va initialiser les stations en les affichant toute sans trie de base
        ObservableList<Station> list = getLesStations();
        tableView.setItems(list);

    }

    // Cette fonction permet la récupération de toute les stations
    private ObservableList<Station>getLesStations() {
        list = FXCollections.observableArrayList(c.getMesStations());
        return list;
    }

    @FXML
    // Dès que le client appuie sur un arrondissement, département ou autre, il y aura les stations liés à son choix
    private void changed(ActionEvent e) {
        // on crée une liste intérmediaire permettant de recenser toutes les stations égales à la condition
        ArrayList<Station>list_intermediaires = new ArrayList<>();

        // On renitialise le tableau de toutes les stations
        list.clear();

        // Récupération du text du radioButton
        RadioButton radioChoix = (RadioButton) e.getSource();

        // Pour chaques stations on vérifie si il est égal avec celui choisis par le client
        for(Station s : c.getMesStations()) {
            if(s.getArrondissement().equals(radioChoix.getText())) {

                list_intermediaires.add(s);

            }
        }
        // On affiche la liste dans le Table View
        list = FXCollections.observableArrayList(list_intermediaires);
        tableView.setItems(list);

    }

    @FXML
    // TODO réaliser le code permettant de changer la disponibilité des stations - AVANT LE 23/03/22
    private void changedDispo(ActionEvent e) {

    }



}