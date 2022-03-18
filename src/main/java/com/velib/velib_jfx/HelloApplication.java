package com.velib.velib_jfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 740);
        stage.setTitle("Disponibilité des stations de Vélib");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

        /*
        Carte c = new Carte();

        c = JPasserelle.getCarte();

        System.out.println(c.nbStations());
        System.out.println(c.getLaStation(0));
        System.out.println(c.chercher("34012"));
        */

    }


}