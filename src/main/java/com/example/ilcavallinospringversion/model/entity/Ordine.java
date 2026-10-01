package com.example.ilcavallinospringversion.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="ordini")
public class Ordine {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate data;
    private List<Prodotto> prodottiOrdine;

    public Ordine(){

    }
    public Ordine(long id, LocalDate data, List<Prodotto> prodottiOrdine){
        this.id=id;
        this.data=data;
        this.prodottiOrdine=prodottiOrdine;
    }
    public long getId(){
        return id;
    }

    public LocalDate getData(){
        return data;
    }
    public List<Prodotto> getProdottiOrdine (){
        return prodottiOrdine;
    }
    public double getTotale(){
        double totale = 0;
        for (Prodotto p : prodottiOrdine){
            totale += p.getPrezzo();
        }
        return totale;
    }
    public void setId(long id){
        this.id=id;
    }

    public void setData(LocalDate data){
        this.data=data;
    }

    public void setProdottiOrdine(List<Prodotto> prodotti){
        this.prodottiOrdine=prodotti;
    }
}
