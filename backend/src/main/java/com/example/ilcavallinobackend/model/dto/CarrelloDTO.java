package com.example.ilcavallinobackend.model.dto;

import java.util.List;

public class CarrelloDTO {
    private Long id;
    private String username;
    private List<RigaCarrelloDTO> elenco;

    public CarrelloDTO(Long id, String username, List<RigaCarrelloDTO> elenco){
        this.id=id;
        this.username=username;
        this.elenco=elenco;
    }

    public CarrelloDTO() {

    }

    public Long getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public List<RigaCarrelloDTO> getElenco(){
        return elenco;
    }

    public void setId(Long id){
        this.id=id;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setElenco(List<RigaCarrelloDTO> elenco){
        this.elenco=elenco;
    }
}
