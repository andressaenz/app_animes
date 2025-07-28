package com.app.anime;


import com.app.anime.model.RepositorioUsuario;
import com.app.anime.model.Usuario;
import com.app.anime.service.ServicioUsuario;

public class AppAnimeApplication {
    public static void main(String [] args) {

        //Usuario usuarioPrueba = new Usuario("Andres", "Yoforever*");
        //ServicioUsuario.registraUsuario(usuarioPrueba);

        Usuario usuarioIngreso = new Usuario("Andres", "Yoforever2018*");
        ServicioUsuario.login(usuarioIngreso);
    }
}
