package com.app.anime.model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class RepositorioUsuario {

    //Metodo encargado de guardar un nuevo usuario si este no existe por correo
    public static void agregarNuevoUsuario(Usuario usuario){

        try(Connection conn = PostgresConector.getConnection()) {

            crearTablaUsuarios(conn);

            String sql = "INSERT INTO tbUsuarios (usuario, contraseña) VALUES (?,?)";

            try( PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, usuario.getUsuario());
                stmt.setString(2, usuario.getContrasena());
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Registro exitoso.");
            }
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    //Metodo encargado de crear tbUsuarios si no existe
    public static void crearTablaUsuarios(Connection conn){
        String sql = "CREATE TABLE IF NOT EXISTS tbUsuarios (" +
                "id SERIAL PRIMARY KEY, " +
                "usuario VARCHAR(50) NOT NULL, " +
                "contraseña VARCHAR(100) NOT NULL" +
                ");";

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql); //Actualiza la base de datos con la nueva tabla
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
