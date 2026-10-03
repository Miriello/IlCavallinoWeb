package com.example.ilcavallinospringversion.model.dto;


import com.example.ilcavallinospringversion.model.entity.Prodotto;
import com.example.ilcavallinospringversion.model.entity.Utente;

import java.util.Map;

public class CarrelloDTO {
    private long id;
    private Utente utente;
    private Map<Prodotto, Integer> elenco;

    public CarrelloDTO(long id, Utente utente, Map<Prodotto, Integer> elenco){
        this.id=id;
        this.utente=utente;
        this.elenco=elenco;
    }

    public CarrelloDTO() {

    }

    public long getId(){
        return id;
    }

    public Utente getUtente(){
        return utente;
    }

    public Map<Prodotto,Integer> getElenco(){
        return elenco;
    }

    public void setId(long id){
        this.id=id;
    }

    public void setUtente(Utente utente){
        this.utente=utente;
    }

    public void setElenco(Map<Prodotto, Integer> elenco){
        this.elenco=elenco;
    }
}
