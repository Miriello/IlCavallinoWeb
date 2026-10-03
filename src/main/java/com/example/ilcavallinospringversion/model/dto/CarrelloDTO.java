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
