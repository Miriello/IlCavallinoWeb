package com.example.ilcavallinospringversion.model.entity;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name="carrello")
public class Carrello {

    @Id
    @GeneratedValue
    private long id;

    private Map<Prodotto,Integer> prodotti;

    @OneToOne(optional = false)
    @JoinColumn(name="utente_id", nullable = false, unique = true)
    private Utente utente;


    public Carrello(){

    }

    public long getId(){
        return id;
    }

    public Map<Prodotto,Integer> getProdotti(){
        return prodotti;
    }

    public Utente getUtente(){
        return utente;
    }

    public double getTotale(){
        double totale = 0.0;
        for(Map.Entry<Prodotto, Integer> p : prodotti.entrySet()){
            totale += (p.getKey().getPrezzo() * p.getValue());
        }
        return totale;
    }

    public void setId(long id){
        this.id=id;
    }

    public void setProdotti(Map<Prodotto,Integer> prodotti){
        this.prodotti=prodotti;
    }

    public void setUtente(Utente utente){
        this.utente=utente;
    }

}
