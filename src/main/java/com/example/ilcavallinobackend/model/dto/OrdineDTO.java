package com.example.ilcavallinobackend.model.dto;

import com.example.ilcavallinobackend.model.entity.Carrello;

import java.time.LocalDate;
public class OrdineDTO {

    private long id;
    private String username;
    private LocalDate data;
    private Carrello carrello;

    public OrdineDTO(){

    }

    public OrdineDTO(long id, String username, LocalDate data, Carrello carrello){
        this.id=id;
        this.username=username;
        this.data=data;
        this.carrello=carrello;
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

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello (Carrello carrello) {
        this.carrello = carrello;
    }
}
