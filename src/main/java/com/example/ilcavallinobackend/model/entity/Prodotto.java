package com.example.ilcavallinobackend.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="prodotti")
public class Prodotto {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String nome;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoriaProdotto categoriaProdotto;
    private String descrizione;
    @Column(nullable = false)
    private double prezzo;
    @ManyToMany
    private List<Ingrediente> ingredienti = new ArrayList<>();
    private String urlImg;

    public Prodotto(){
    }

    public Prodotto(String nome, List<Ingrediente> ingredienti){
        this.nome=nome;
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

    public void setId(long id){
        this.id=id;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setIngredienti(List<Ingrediente> ingredienti){
        this.ingredienti=ingredienti;
    }

    public void setCategoriaProdotto(CategoriaProdotto categoriaProdotto){
        this.categoriaProdotto=categoriaProdotto;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setPrezzo(double prezzo){
        this.prezzo=prezzo;
    }

    public void setUrlImg(String urlImg){
        this.urlImg=urlImg;
    }
}
