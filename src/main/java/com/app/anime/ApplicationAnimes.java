package com.app.anime;
import com.app.anime.util.GestorEscena;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ApplicationAnimes extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        GestorEscena.cambiarScena(primaryStage,"/view/VistaLogin.fxml", "");
        primaryStage.setMaximized(true);
    }
}
