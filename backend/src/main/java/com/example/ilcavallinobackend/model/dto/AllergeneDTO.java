package com.example.ilcavallinobackend.model.dto;

import jakarta.validation.constraints.NotBlank;

public class AllergeneDTO {

    private Long id;
    @NotBlank
    private String nome;

    public AllergeneDTO(){

    }

    public AllergeneDTO(Long id, String nome){
        this.id=id;
        this.nome=nome;
    }

    public Long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public void setId(Long id){
        this.id=id;
    }

    public void setNome(String nome){
        this.nome=nome;
    }
}
