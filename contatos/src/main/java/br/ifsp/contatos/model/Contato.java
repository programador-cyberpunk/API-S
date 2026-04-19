package br.ifsp.contatos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contato{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;

    //essa porra é um construtor vazio que vem padrao
    public Contato(){}

    //construtor pra facilitar a minha vida
    public Contato(String nome, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    //get e set
    public Long getId(){
        return id;
    }
    public void setId(Long id){

    }

    public String getNome(){
        return nome;
    }
    public void  setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
}