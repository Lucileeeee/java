package com.dossier.Co_bdd.repository;
import com.dossier.Co_bdd.bdd.BaseDeDonnee;
import com.dossier.Co_bdd.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserRepository {
    //Attributs
    private static Connection connection = BaseDeDonnee.getConnection();
    //Methodes
    //on met en static pour pas avoir à faire des new User pour utiliser cette fonction
    public static User save(User addUser){
        User newUser = null;
        try {
            //Requete
            String sql = "INSERT INTO users(firstname, lastname, email, password) VALUE (?,?,?,?)";
            //Préparer la requete
            PreparedStatement preparedStatement = connection.prepareStatement(sql); //equivalent du prepare sur PDO Bdd en php
            //Bind des Parametres
            preparedStatement.setString(1, addUser.getFirstname()); // pour correspondre aux "?", correspond au typage, si int ->setInt
            preparedStatement.setString(2, addUser.getLastname());
            preparedStatement.setString(3, addUser.getEmail());
            preparedStatement.setString(4, addUser.getPassword());
            //Executer la Requete
            int nbRows = preparedStatement.executeUpdate();
            if(nbRows > 0){
                newUser = new User(
                addUser.getFirstname(),
                addUser.getLastname(),
                addUser.getEmail(),
                addUser.getFirstname()
                );
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return newUser;
    }
}
