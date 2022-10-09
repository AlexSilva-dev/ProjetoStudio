/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;
import DTO.ClientesDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
/**
 *
 * @author alex
 */
public class ClienteDAO {
    // Atributos
    Connection objConnection = null;
    PreparedStatement objPreparedSta;
    
    // Métodos
    public void inserir(ClientesDTO objClientDTO){
        
        objConnection = new ConexaoDB().conectarDB();
        String sql = "insert into cliente "
                    + "(idCliente, nome, cpf, numCell)"
                    + "value"
                    + "(default, ?, ?, ?)";
        try
        {
           
            
            objPreparedSta = objConnection.prepareStatement(sql);
            objPreparedSta.setString(1, objClientDTO.getNome());
            objPreparedSta.setLong(2, objClientDTO.getCpf());
            objPreparedSta.setLong(3, objClientDTO.getNumCell());
            
            objPreparedSta.execute();
            objPreparedSta.close();
            
            return ;
                    
        } catch (SQLException erro)
        {
            JOptionPane.showMessageDialog(null, "ClienteDAO " + erro);
            return ;
        }
    }
    
}
