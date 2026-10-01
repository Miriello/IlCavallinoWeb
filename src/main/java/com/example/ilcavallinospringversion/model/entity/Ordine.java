package com.example.ilcavallinospringversion.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Table(name="ordini")
public class Ordine {

    private List<Prodotto> prodottiOrdine;

    public Ordine(){

    }
    public Ordine(List<Prodotto> prodottiOrdine){
        this.prodottiOrdine=prodottiOrdine;
    }

    public double getTotale(){
        double totale = 0;
        for (Prodotto p : prodottiOrdine){
            totale += p.getPrezzo();
        }
        return totale;
    }
}
