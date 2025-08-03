package com.app.anime.service;

import com.app.anime.model.PostgresConector;
import com.app.anime.model.RepositorioUsuario;
import com.app.anime.model.Usuario;


import java.sql.Connection;

public class ServicioUsuario {

    // Metodo que permite registrar un nuevo usuario
    public static boolean registraUsuario(Usuario usuario) {

        try(Connection conn = PostgresConector.obtenerConexion()) {
            RepositorioUsuario.crearTablaUsuarios(conn);
            if (RepositorioUsuario.usuarioExiste(usuario.getUsuario(), conn)) {
                return false;
            }
            RepositorioUsuario.guardarUsuario(usuario, conn);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Metodo que ayuda a iniciar la sesion del usuario
    public static boolean login(Usuario usuario){

        try (Connection conn = PostgresConector.obtenerConexion()){
            if (RepositorioUsuario.verificarContrasena(usuario, conn)){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
