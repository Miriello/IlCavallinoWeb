package com.example.ilcavallinobackend.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class RigaCarrello {

    @Id
    @GeneratedValue
    private long id;
    private Prodotto prodotto;
    private int unita;
    private double prezzo;

    public RigaCarrello(){

    }

    public RigaCarrello(long id, Prodotto prodotto, int unita, double prezzo){
        this.id=id;
        this.prodotto=prodotto;
        this.unita=unita;
        this.prezzo=prezzo;
    }

    public long getId(){
        return id;
    }
    public Prodotto getProdotto(){
        return prodotto;
    }

    public int getUnita(){
        return unita;
    }

    public double getPrezzo(){
        return prezzo;
    }

    public void setId(long id){
        this.id=id;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public void setUnita(int unita) {
        this.unita = unita;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
