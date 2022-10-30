/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;
import DTO.ClienteDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author alex
 */
public class ClienteDAO {
    // Atributos
    Connection objConnection = null;
    PreparedStatement objPreparedSta;
    ResultSet result;
    
    // Métodos
    public void inserir(ClienteDTO objClientDTO){
        
        objConnection = new ConexaoDB().conectarDB();
        String sql = "insert into cliente "
                    + "(idCliente, nome, cpf, numCell)"
                    + "value"
                    + "(default, ?, ?, ?)";
        try
        {
           
            
            objPreparedSta = objConnection.prepareStatement(sql);
            objPreparedSta.setString(1, objClientDTO.getNome());
            objPreparedSta.setString(2, objClientDTO.getCpf());
            objPreparedSta.setString(3, objClientDTO.getNumCell());
            
            objPreparedSta.execute();
            objPreparedSta.close();
            
            return ;
                    
        } catch (SQLException erro)
        {
            JOptionPane.showMessageDialog(null, "ClienteDAO " + erro);
            return ;
        }
    }
    
    public ArrayList<ClienteDTO> listar(){
        
        String sql = "select * from cliente";
        ArrayList<ClienteDTO> arrayClienteDTO = new ArrayList<>();
        
        
        try {
            objConnection = new ConexaoDB().conectarDB();
            objPreparedSta = objConnection.prepareStatement(sql);
            result = objPreparedSta.executeQuery();
            
            while(result.next()){
                ClienteDTO objNewClienteDTO = new ClienteDTO();
                objNewClienteDTO.setIdClient(result.getInt("idCliente"));
                objNewClienteDTO.setNome(result.getString("nome"));
                objNewClienteDTO.setCpf(result.getString("cpf"));
                objNewClienteDTO.setNumCell(result.getString("numCell"));
                
                arrayClienteDTO.add(objNewClienteDTO);
                
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ClienteDAO: " + erro);
            
        }
        return arrayClienteDTO;
    }
    
}
