package com.example.ilcavallinospringversion.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="persone")
public class Persona {

    @Id
    private String codiceFiscale;

    private String nome;
    private String cognome;
    private Ruolo ruolo;

    //Obbligatorio costruttore vuoto senza parametri per JPA.
    public Persona(){

    }

    public Persona (String codiceFiscale, String nome, String cognome, Ruolo ruolo){
        this.codiceFiscale=codiceFiscale;
        this.nome=nome;
        this.cognome=cognome;
        this.ruolo=ruolo;
    }

    public String getCodiceFiscale(){
        return codiceFiscale;
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public Ruolo getRuolo(){
        return ruolo;
    }

    public void setCodiceFiscale(String codiceFiscale){
        this.codiceFiscale=codiceFiscale;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setCognome(String cognome){
        this.cognome=cognome;
    }

    public void setRuolo(Ruolo ruolo){
        this.ruolo=ruolo;
    }
}
