package com.example.ilcavallinobackend.model.dto;

import com.example.ilcavallinobackend.model.entity.Carrello;

import java.time.LocalDate;
public class OrdineDTO {

    private long id;
    private String username;
    private LocalDate data;
    private CarrelloDTO carrelloDTO;

    public OrdineDTO(){

    }

    public OrdineDTO(long id, String username, LocalDate data, CarrelloDTO carrelloDTO){
        this.id=id;
        this.username=username;
        this.data=data;
        this.carrelloDTO=carrelloDTO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public CarrelloDTO getCarrello() {
        return carrelloDTO;
    }

    public void setCarrello (CarrelloDTO carrelloDTO) {
        this.carrelloDTO = carrelloDTO;
    }
}
