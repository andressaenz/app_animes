package com.app.anime.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConector {


    private static final String URL = "jdbc:postgresql://localhost:5432/usuarios_db_app_animes";
    private static final String USUARIO = "postgres";
    private static final String CONTRASENA = "Adminpost2025*";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
