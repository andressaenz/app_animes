package com.app.anime.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GestorEscena {

    public static void cambiarScena(Stage stage, String rutaFXML, String titulo){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(GestorEscena.class.getResource(rutaFXML));
            Scene scene = new Scene(fxmlLoader.load());

            scene.getStylesheets().addAll(
                    GestorEscena.class.getResource("/css/base.css").toExternalForm(),
                    GestorEscena.class.getResource("/css/componentes.css").toExternalForm()
            );

            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
        }catch (IOException e){
            System.err.println("Error al cambiar de escena: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
