package com.example.ilcavallinospringversion.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="prodotti")
public class Prodotto {

    @Id
    @GeneratedValue
    private long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private CategoriaProdotto categoriaProdotto;
    private String descrizione;
    private double prezzo;
    @OneToMany
    private List<Ingrediente> ingredienti = new ArrayList<>();
    private String urlImg;

    public Prodotto(){
    }

    public Prodotto(String nome, List<Ingrediente> ingredienti){
        this.nome=nome;
        this.ingredienti=ingredienti;
    }
    //--------//
    // GETTER //
    //--------//
    public long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public List<Ingrediente> getIngredienti(){
        return ingredienti;
    }

    public CategoriaProdotto getCategoriaProdotto(){
        return categoriaProdotto;
    }

    public String getDescrizione(){
        return descrizione;
    }

    public double getPrezzo(){
        return prezzo;
    }

    public String getUrlImg(){
        return urlImg;
    }

    //--------//
    // SETTER //
    //--------//
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
