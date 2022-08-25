/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class ConexaoDB {

   

    public Connection conectarDB() {
        String url = "jdbc:mysql://localhost:3306/ProjStudioDB";
        String user = "root";
        String senha = "12345678";
        Connection objConn = null;

        try
        {
            objConn = DriverManager.getConnection(url, user, senha);
            System.out.println("Deu certo");
        } catch (SQLException erro)
        {
            JOptionPane.showMessageDialog(null, "ConexãoDAO " + erro.getMessage());
            return null;
        }

        return objConn;

    }

}
