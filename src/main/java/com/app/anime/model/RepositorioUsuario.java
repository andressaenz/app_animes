package com.app.anime.model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RepositorioUsuario {

    //Metodo encargado de guardar un nuevo usuario si este no existe por correo
    public static void agregarNuevoUsuario(Usuario usuario){
        String sql = "INSET INTO tbUsuarios (usuario, contraseña) VALUES (?,?)";

        try(Connection conn = PostgresConector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            crearTablaUsuarios();
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getContraseña());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro exitoso.");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Metodo encargado de comprobar si tbUsuarios existe en usuarios_db_app_animes
    public static boolean tablaUsuariosExiste(){
        String consulta = "SELECT EXISTS (" +
                "SELECT FROM information_schema.tables " +
                "WHERE table_schema = 'public' AND table_name = 'tbUsuarios'" +
                ");";
        try(Connection conn = PostgresConector.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta)
            ) {
            if(rs.next()){ return rs.getBoolean(1); }
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    //Metodo encargado de crear tbUsuarios si no existe
    public static void crearTablaUsuarios(){
        if(!tablaUsuariosExiste()){
            String sql = "CREATE TABLE tbUsuarios (" +
                    "id SERIAL PRIMARY KEY, " +
                    "usuario VARCHAR(50) NOT NULL, " +
                    "contraseña VARCHAR(100) NOT NULL" +
                    ");";

            try (Connection conn = PostgresConector.getConnection();
                Statement stmt = conn.createStatement();
                ){

                stmt.executeUpdate(sql); //Actualiza la base de datos con la nueva tabla
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
