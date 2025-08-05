package com.app.anime.util;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class GestorEscena {

    // Permite el cambio de escena pasandola por parametro junto a la ruta del fxml
    public static void cambiarScena(Stage stage, String rutaFXML, String titulo){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(GestorEscena.class.getResource(rutaFXML));
            Scene scene = new Scene(fxmlLoader.load());

            scene.getStylesheets().addAll(
                    GestorEscena.class.getResource("/css/styleVistaPrincipal.css").toExternalForm(),
                    GestorEscena.class.getResource("/css/styleVistaLogin.css").toExternalForm()
            );

            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            System.err.println("Error al cambiar de escena: " + e.getMessage());
            e.printStackTrace();
        }

    }

    // Cierra la aplicacion una ves se presione el boton que se paso por parametero
    public static void cerrarPrograma(Button btnCerrar){
        btnCerrar.setOnAction(event -> Platform.exit());
    }
}
