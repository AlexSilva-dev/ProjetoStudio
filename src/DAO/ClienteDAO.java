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
        
        result = null;
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
        
        result = null;
        String sql = "select * from cliente";
        ArrayList<ClienteDTO> arrayClienteDTO = new ArrayList<>();
        
        
        try {
            objConnection = new ConexaoDB().conectarDB();
            objPreparedSta = objConnection.prepareStatement(sql);
            result = objPreparedSta.executeQuery();
            arrayClienteDTO = criarListaCliente(result);
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ClienteDAO: " + erro);
            
        }
        return arrayClienteDTO;
    }
    
    public ArrayList<ClienteDTO> pesquisar(ClienteDTO objClienteConsult){
        
        result = null;
        String sql = "select * from cliente where ";
        
        try
        {
            objConnection = new ConexaoDB().conectarDB();
            
            if(objClienteConsult.getIdClient() != null){
                sql += "idCliente = ?";
                objPreparedSta = objConnection.prepareStatement(sql);
                objPreparedSta.setInt(1, objClienteConsult.getIdClient());
                
                
            } else if(objClienteConsult.getNome() != null){
                
                sql += "nome = ?";
                objPreparedSta = objConnection.prepareStatement(sql);
                objPreparedSta.setString(1, objClienteConsult.getNome());
               
                
            } else if(objClienteConsult.getCpf() != null){
                sql += "cpf = ?";
                objPreparedSta = objConnection.prepareStatement(sql);
                objPreparedSta.setInt(1, objClienteConsult.getIdClient());
                
            }
            
            result = objPreparedSta.executeQuery();
            ArrayList<ClienteDTO> arrayClienteDTO = new ArrayList<>();
            arrayClienteDTO = criarListaCliente(result);
            return arrayClienteDTO;
            
        } catch (SQLException erro)
        {
            JOptionPane.showMessageDialog(null, "ClienteDAO: " + erro);
            return null;
        }
        
        
                
    }
    
    private ArrayList<ClienteDTO> criarListaCliente(ResultSet objResult){
        
        ArrayList<ClienteDTO> arrayClienteDTO = new ArrayList<>();
        try
        {
            while(objResult.next()){
                ClienteDTO objNewClienteDTO = new ClienteDTO();
                objNewClienteDTO.setIdClient(objResult.getInt("idCliente"));
                objNewClienteDTO.setNome(objResult.getString("nome"));
                objNewClienteDTO.setCpf(objResult.getString("cpf"));
                objNewClienteDTO.setNumCell(objResult.getString("numCell"));
                
                arrayClienteDTO.add(objNewClienteDTO);
                
            }
        } catch (SQLException erro)
        {
            
            JOptionPane.showMessageDialog(null, "ClienteDAO.criarListaCliente: " + erro);
            return null;
        }
        
        return arrayClienteDTO;
        
    }
    
}
