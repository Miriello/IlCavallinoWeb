package com.example.ilcavallinospringversion.model.dto;


import com.example.ilcavallinospringversion.model.entity.Utente;
import com.example.ilcavallinospringversion.utility.RigaCarrello;

import java.util.List;

public class CarrelloDTO {
    private long id;
    private String username;
    private List<RigaCarrello> elenco;

    public CarrelloDTO(long id, String username, List<RigaCarrello> elenco){
        this.id=id;
        this.username=username;
        this.elenco=elenco;
    }

    public CarrelloDTO() {

    }

    public long getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public List<RigaCarrello> getElenco(){
        return elenco;
    }

    public void setId(long id){
        this.id=id;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setElenco(List<RigaCarrello> elenco){
        this.elenco=elenco;
    }
}
