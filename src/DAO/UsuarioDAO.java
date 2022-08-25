/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import DTO.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author alex
 */
public class UsuarioDAO {

    Connection objConn = null;

    public ResultSet autenticacao(UsuarioDTO objUsuario) {

        objConn = new ConexaoDB().conectarDB();

        try{
            String sql = "select * from usuario "
                    + "where usuario = ? and senha = ?";
            PreparedStatement pst = objConn.prepareStatement(sql);
            pst.setString(1, objUsuario.getUsuario());
            pst.setString(2, objUsuario.getPassword());
            
            ResultSet resul = pst.executeQuery();
            return resul;

        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"UsuarioDAO " + erro.getMessage());
            return null;
            
        }

    }
}
