package com.example.ilcavallinospringversion.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="piatti")
public class Piatto {

    @Id
    @GeneratedValue
    private long id;


    private String nome;
    private double prezzo;

    @OneToMany
    private List<Ingrediente> ingredienti = new ArrayList<>();

    public Piatto(){
    }

    public Piatto(String nome, List<Ingrediente> ingredienti){
        this.nome=nome;
        this.prezzo
        this.ingredienti=ingredienti;
    }

    public long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public List<Ingrediente> getIngredienti(){
        return ingredienti;
    }

    public void setId(long id){
        this.id=id;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setIngredienti(List<Ingrediente> ingredienti){
        this.ingredienti=ingredienti;
    }
}
