package com.example.ilcavallinospringversion.model.dto;

import com.example.ilcavallinospringversion.model.entity.Prodotto;
import com.example.ilcavallinospringversion.model.entity.Utente;

import java.time.LocalDate;
import java.util.List;

public class OrdineDTO {

    private long id;
    private Utente utente;
    private LocalDate data;
    private List<Prodotto> prodottiOrdine;

    public OrdineDTO(){

    }

    public OrdineDTO(long id, Utente utente, LocalDate data, List<Prodotto> prodottiOrdine){
        this.id=id;
        this.utente=utente;
        this.data=data;
        this.prodottiOrdine=prodottiOrdine;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Utente getUtente(){
        return utente;
    }

    public void setUtente(Utente utente){
        this.utente=utente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<Prodotto> getProdottiOrdine() {
        return prodottiOrdine;
    }

    public void setProdottiOrdine(List<Prodotto> prodottiOrdine) {
        this.prodottiOrdine = prodottiOrdine;
    }
}
