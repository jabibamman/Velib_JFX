package com.velib.velib_jfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    // Déclarations des variables
    Carte c;
    ObservableList<Station> list;
    @FXML
    Label date, v_dispo, nb_total_pAcces, etatStation, pointAttacheDispo, cb_dispo, adresse;
    @FXML
    TableColumn<Station, String> numStation, adresseTree, cbDispoTree, ouvert;
    @FXML
    TableView<Station> tableView;


    @Override
    // Cette fonction permet l'intialisation des Objets, un peu comme un Main
    public void initialize(URL url, ResourceBundle resourceBundle) {
        c = JPasserelle.getCarte();

        // On indique quel objet possède quel valeur dans la classe Station
        numStation.setCellValueFactory(new PropertyValueFactory<>("numero"));
        adresseTree.setCellValueFactory(new PropertyValueFactory<>("nom"));
        cbDispoTree.setCellValueFactory(new PropertyValueFactory<>("cbDispo"));
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
    private void changerArrondissement(ActionEvent e) {
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
    // Dès que le client appuie sur une autre station, alors on affiche les données de cette station..
    private void changerDispo() {
        adresse.setText(tableView.getSelectionModel().getSelectedItem().getNom());
        date.setText("le : " + String.valueOf(tableView.getSelectionModel().getSelectedItem().getDate()));
        v_dispo.setText("Vélos disponibles : " + String.valueOf(tableView.getSelectionModel().getSelectedItem().getVelo_disp()));
        nb_total_pAcces.setText("Nombre total de points d'attache : " + String.valueOf(tableView.getSelectionModel().getSelectedItem().getCapacite()));
        etatStation.setText("Station Ouverte : " + tableView.getSelectionModel().getSelectedItem().isOuvert());
        pointAttacheDispo.setText("Points d'attache disponbiles : " + String.valueOf(tableView.getSelectionModel().getSelectedItem().getEmplacement_disp()));
        cb_dispo.setText("Location par carte bancaire : " + tableView.getSelectionModel().getSelectedItem().getCbDispo());

        // On affiche l'état de la station en vert, quand elle est ouverte
        if(tableView.getSelectionModel().getSelectedItem().isOuvert().equals("OUI")) {
            etatStation.setTextFill(Color.color(0, 1, 0));
        }else{
            etatStation.setTextFill(Color.color(1, 0, 0));
        }

    }



}