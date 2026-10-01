package com.example.ilcavallinospringversion.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Allergene {

    @Id
    @GeneratedValue
    private long id;

    private String nome;

    public Allergene(){

    }

    public Allergene (long id, String nome){
        this.id=id;
        this.nome=nome;
    }

    public long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public void setId(long id){
        this.id=id;
    }

    public void setNome(String nome){
        this.nome=nome;
    }
}
