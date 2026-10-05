package com.example.ilcavallinobackend.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="allergeni")
public class Allergene {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
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
