/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author miolivc
 */
public class ConnectionFactory {
  
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:; INIT=RUNSCRIPT"
                    + " FROM './src/main/resources/schema.sql'\\;", "sa", "");
        } catch (SQLException ex) {
            System.err.println("Erro ao se conectar ao banco: " + ex);
        }
        return connection;
    }
    
}
