package com.example.ilcavallinospringversion.model.dto;


import com.example.ilcavallinospringversion.model.entity.Prodotto;
import com.example.ilcavallinospringversion.model.entity.Utente;
import com.example.ilcavallinospringversion.utility.RigaCarrello;

import java.util.List;
import java.util.Map;

public class CarrelloDTO {
    private long id;
    private Utente utente;
    private List<RigaCarrello> elenco;

    public CarrelloDTO(long id, Utente utente, List<RigaCarrello> elenco){
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

    public List<RigaCarrello> getElenco(){
        return elenco;
    }

    public void aggiungiRiga(RigaCarrello rg){
        this.elenco.add(rg);
    }

    public void rimuoviRiga(int indice){
        this.elenco.remove(indice);
    }

    public void rimuoviRiga(Prodotto p){
        int indice = 0;
        for(RigaCarrello rg : elenco){
            indice++;
            if(rg.getProdotto() == p){
                rimuoviRiga(indice);
            }
        }
    }

    public boolean prodottoPresente(Prodotto prodotto){
        for(RigaCarrello rg : elenco){
            if(rg.getProdotto() == prodotto){
                return true;
            }
        }
        return false;
    }

    public void modificaQuantita(Prodotto prodotto, int nuovaQuantita){
        if(nuovaQuantita < 0){
            throw new IllegalArgumentException("La quantità non può essere negativa");
        }
        if(nuovaQuantita == 0){
            rimuoviRiga(prodotto);
        }
        else {
            for (RigaCarrello rg : elenco) {
                if (rg.getProdotto() == prodotto) {
                    rg.setUnita(nuovaQuantita);
                }
            }
        }
    }

    public void modificaPrezzo(Prodotto prodotto, double nuovoPrezzo){
        if(nuovoPrezzo <= 0){
            throw new IllegalArgumentException("Il prezzo non può essere negativo");
        }
        for(RigaCarrello rg: elenco){
            if(rg.getProdotto()== prodotto){
                rg.setPrezzo(nuovoPrezzo);
            }
        }
    }

    public int getQuantitaProdotto(Prodotto prodotto){
        for(RigaCarrello rg: elenco){
            if(rg.getProdotto()==prodotto){
                return rg.getUnita();
            }
        }
        return 0;
    }

    public void setId(long id){
        this.id=id;
    }

    public void setUtente(Utente utente){
        this.utente=utente;
    }

    public void setElenco(List<RigaCarrello> elenco){
        this.elenco=elenco;
    }
}
