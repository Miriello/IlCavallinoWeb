package com.example.ilcavallinospringversion.model.entity;

import jakarta.persistence.Entity;

@Entity
public class RigaCarrello {

    private Prodotto prodotto;
    private int unita;
    private double prezzo;

    public RigaCarrello(Prodotto prodotto, int unita, double prezzo){
        this.prodotto=prodotto;
        this.unita=unita;
        this.prezzo=prezzo;
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
