package com.app.anime;


import com.app.anime.model.RepositorioUsuario;
import com.app.anime.model.Usuario;

public class AppAnimeApplication {
    public static void main(String [] args) {

        Usuario usuarioPrueba = new Usuario("Andres", "Yoforever*");
        RepositorioUsuario.agregarNuevoUsuario(usuarioPrueba);
    }
}
