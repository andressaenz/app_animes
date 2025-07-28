package com.app.anime.model;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConector {

    private static final Dotenv dotenv = Dotenv.load();

    private static final String URL = dotenv.get("DB_URL");
    private static final String USUARIO = dotenv.get("DB_USUARIO");
    private static final String CONTRASENA = dotenv.get("DB_CONTRASENA");

    //Metodo encargado de la conexion a la base de datos
    public static Connection obtenerConexion() throws SQLException {

        try {
            return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
