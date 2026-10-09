package com.example.ilcavallinobackend.model.dto;

import com.example.ilcavallinobackend.model.entity.Prodotto;

public class RigaCarrelloDTO {
    private ProdottoDTO prodottoDTO;
    private int unita;
    private double prezzo;

    public RigaCarrelloDTO(){

    }

    public RigaCarrelloDTO(ProdottoDTO prodottoDTO, int unita, double prezzo) {
        this.prodottoDTO=prodottoDTO;
        this.unita=unita;
        this.prezzo=prezzo;
    }

    public ProdottoDTO getProdottoDTO(){
        return prodottoDTO;
    }

    public int getUnita(){
        return unita;
    }

    public double getPrezzo(){
        return prezzo;
    }

    public void setProdottoDTO(ProdottoDTO prodottoDTO){
        this.prodottoDTO=prodottoDTO;
    }

    public void setUnita(int unita){
        this.unita=unita;
    }

    public void setPrezzo(double prezzo){
        this.prezzo=prezzo;
    }
}
