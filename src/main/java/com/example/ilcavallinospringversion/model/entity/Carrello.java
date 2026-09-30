package com.example.ilcavallinospringversion.model.entity;

import jakarta.persistence.*;

import java.util.Map;

@Entity
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

    public double getTotale(){
        double totale = 0.0;
        for(Map.Entry<Prodotto, Integer> p : prodotti.entrySet()){
            totale += (p.getKey().getPrezzo() * p.getValue());
        }
        return totale;
    }

}
