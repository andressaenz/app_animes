package com.app.anime.controller;

import com.app.anime.model.Usuario;
import com.app.anime.service.ServicioUsuario;
import com.app.anime.util.GestorEscena;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControladorLogin {

    @FXML private TextField loginUsuario;
    @FXML private PasswordField pwUsuario;

    @FXML
    protected void loginUsuario(ActionEvent event){
        Usuario usuario = new Usuario(loginUsuario.getText(), pwUsuario.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        boolean validar = ServicioUsuario.login(usuario);

        if (validar){
            Stage stage = (Stage) loginUsuario.getScene().getWindow();
            GestorEscena.cambiarScena(stage, "/view/VistaPrincipal.fxml", "Pricipal APP-Animes");
        } else {
            alert.setTitle("Login fallido");
            alert.setHeaderText(null);
            alert.setContentText("Usuario o contraseña incorrecta.");
            alert.showAndWait();
        }

    }

}
