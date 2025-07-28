package com.app.anime.service;

import com.app.anime.model.PostgresConector;
import com.app.anime.model.RepositorioUsuario;
import com.app.anime.model.Usuario;

import javax.swing.*;
import java.sql.Connection;

public class ServicioUsuario {

    public static void registraUsuario(Usuario usuario) {

        try(Connection conn = PostgresConector.obtenerConexion()) {
            RepositorioUsuario.crearTablaUsuarios(conn);
            if (RepositorioUsuario.usuarioExiste(usuario.getUsuario(), conn)) {
                JOptionPane.showMessageDialog(null, "El usuario ya existe");
                return;
            }

            RepositorioUsuario.guardarUsuario(usuario, conn);
            JOptionPane.showMessageDialog(null, "Registro exitoso.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al registrar el usuario.");
        }
    }

    public static boolean login(Usuario usuario){

        try (Connection conn = PostgresConector.obtenerConexion()){
            if (RepositorioUsuario.verificarContrasena(usuario, conn)){
                JOptionPane.showMessageDialog(null, "Acceso permitido");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
