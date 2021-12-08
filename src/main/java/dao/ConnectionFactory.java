/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcelapsilverio
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sorteio", "postgres", "postgres");
        } catch (SQLException erro) {
            throw new RuntimeException("Erro 1: " + erro + "\n");
        }
        return conexao;
    }
    
}
