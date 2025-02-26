package com.dossier.Co_bdd.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDonnee {
    //Attribut paramètre BDD
    static final String DB_URL = "jdbc:mysql://127.0.0.1/java";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    //Connexion à la BDD
    private static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection(){
        return connection;
    }
}
