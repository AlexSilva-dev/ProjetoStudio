/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DTO;

/**
 *
 * @author alex
 */
public class ClientesDTO {
    
    // Atributos
    private int idClient;
    private String nome;
    private long cpf;
    private long numCell;
    
    // Métodos especiais
    public ClientesDTO(String nome, long cpf, long numCell){
        this.nome = nome;
        this.cpf = cpf;
        this.numCell = numCell;
        
        
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getNumCell() {
        return numCell;
    }

    public void setNumCell(long numCell) {
        this.numCell = numCell;
    }
    
  
}
