package com.app.anime.controller;

import com.app.anime.util.GestorEscena;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class ControladorVistaPrincipal {
    @FXML private FlowPane contenedorTarjetas;
    @FXML private Button btnCerrar;

    public void initialize() {
        int cantidadTarjetas = 20;

        for (int i = 1; i <= cantidadTarjetas; i++) {
            VBox tarjeta = crearTarjeta("APP");
            contenedorTarjetas.getChildren().add(tarjeta);
        }

        GestorEscena.cerrarPrograma(btnCerrar);
    }

    protected VBox crearTarjeta(String titulo) {
        VBox tarjeta = new VBox();
        tarjeta.setPrefSize(300, 150);
        tarjeta.setStyle("""
        -fx-background-color: white;
        -fx-border-color: #ccc;
        -fx-border-radius: 8;
        -fx-background-radius: 8;
        -fx-padding: 30;
    """);
        tarjeta.setAlignment(Pos.BOTTOM_RIGHT);
        tarjeta.setSpacing(5);

        Label label = new Label(titulo);
        label.setStyle("-fx-font-size: 16px; -fx-text-fill: #333;");
        tarjeta.getChildren().add(label);

        return tarjeta;
    }

}
