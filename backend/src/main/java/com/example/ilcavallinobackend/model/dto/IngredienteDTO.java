package com.example.ilcavallinobackend.model.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public class IngredienteDTO {

    private Long id;
    @NotBlank
    private String nome;
    private LocalDate scadenza;
    private List<AllergeneDTO> allergeni;

    public IngredienteDTO(){

    }
    public IngredienteDTO(Long id, String nome, LocalDate scadenza, List<AllergeneDTO> allergeni){
        this.id=id;
        this.nome=nome;
        this.scadenza=scadenza;
        this.allergeni=allergeni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public List<AllergeneDTO> getAllergeni() {
        return allergeni;
    }

    public void setAllergeni(List<AllergeneDTO> allergeni) {
        this.allergeni = allergeni;
    }
}
