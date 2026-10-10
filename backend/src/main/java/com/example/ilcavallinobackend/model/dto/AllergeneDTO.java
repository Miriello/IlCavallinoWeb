package com.example.ilcavallinobackend.model.dto;

import jakarta.validation.constraints.NotBlank;

public class AllergeneDTO {

    private long id;
    @NotBlank
    private String nome;

    public AllergeneDTO(){

    }

    public AllergeneDTO(long id, String nome){
        this.id=id;
        this.nome=nome;
    }

    public long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public void setId(long id){
        this.id=id;
    }

    public void setNome(String nome){
        this.nome=nome;
    }
}
