package com.example.ilcavallinobackend.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="ordini")
public class Ordine {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Utente utente;
    private LocalDate data;
    @OneToOne
    private Carrello carrello;

    public Ordine(){

    }
    public Ordine(long id, Utente utente, LocalDate data, Carrello carrello){
        this.id=id;
        this.utente=utente;
        this.data=data;
        this.carrello=carrello;
    }
    public long getId(){
        return id;
    }

    public Utente getUtente(){
        return utente;
    }

    public LocalDate getData(){
        return data;
    }
    public Carrello getCarrello (){
        return carrello;
    }
    public double getTotale(){
        return carrello.getTotale();
    }

    public void setId(long id){
        this.id=id;
    }

    public void setUtente(Utente utente){
        this.utente=utente;
    }

    public void setData(LocalDate data){
        this.data=data;
    }

    public void setCarrello(Carrello carrello){
        this.carrello=carrello;
    }
}
