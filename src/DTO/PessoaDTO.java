/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author alex
 */
public abstract class PessoaDTO {
    //Atributos
    private String nome;
    private String cpf;
    
    // Métodos

    public PessoaDTO(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public PessoaDTO(){
        
    }

    
    
    public String toString(){
        String status = this.nome;
        status += " " + this.cpf;
        return status;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    
    
    
}
