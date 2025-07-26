package com.app.anime.model;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class RepositorioUsuario {

    //Metodo encargado de guardar un nuevo usuario si este no existe
    public static void guardarUsuario(Usuario usuario, Connection conn){

            String sql = "INSERT INTO tbUsuarios (usuario, contraseña) VALUES (?,?)";
            try( PreparedStatement stmt = conn.prepareStatement(sql)) {
                //Hashea la contraseña ingresada por el usuario sin necesidad de almacenarla en alguna variable
                String contrasenaHasheada = BCrypt.hashpw(usuario.getContrasena(), BCrypt.gensalt());
                stmt.setString(1, usuario.getUsuario());
                stmt.setString(2, contrasenaHasheada);
                stmt.executeUpdate();
            }catch (Exception e) { throw new RuntimeException(e); }
    }

    //Metodo encargado de crear tbUsuarios si no existe
    public static void crearTablaUsuarios(Connection conn){

        String sql = "CREATE TABLE IF NOT EXISTS tbUsuarios (" +
                "id SERIAL PRIMARY KEY, " +
                "usuario VARCHAR(50) NOT NULL UNIQUE, " +
                "contraseña VARCHAR(100) NOT NULL" +
                ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Metodo para validar si el usuario existe
    public static boolean usuarioExiste(String usuario, Connection conn){

        String sql = "SELECT COUNT(*) FROM tbUsuarios WHERE usuario = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,usuario);
            var rs = stmt.executeQuery();

            if(rs.next()){
                return rs.getInt(1)>0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
