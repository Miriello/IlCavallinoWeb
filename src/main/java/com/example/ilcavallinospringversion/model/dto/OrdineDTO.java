package com.example.ilcavallinospringversion.model.dto;

import com.example.ilcavallinospringversion.model.entity.Prodotto;

import java.time.LocalDate;
import java.util.List;

public class OrdineDTO {
    private long id;
    private LocalDate data;
    private List<Prodotto> prodottiOrdine;

    public OrdineDTO(){

    }

    public OrdineDTO(long id, LocalDate data, List<Prodotto> prodottiOrdine){
        this.id=id;
        this.data=data;
        this.prodottiOrdine=prodottiOrdine;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
