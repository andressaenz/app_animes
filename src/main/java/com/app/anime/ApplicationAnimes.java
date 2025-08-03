package com.app.anime;
import com.app.anime.util.GestorEscena;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationAnimes extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GestorEscena.cambiarScena(primaryStage,"/view/VistaLogin.fxml","Login APP-Animes");
    }
}
