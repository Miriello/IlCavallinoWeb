package com.example.ilcavallinobackend.model.dto;

import java.time.LocalDate;
import java.util.List;

public class IngredienteDTO {

    private long id;
    private String nome;
    private LocalDate scadenza;
    private List<AllergeneDTO> allergeni;

    public IngredienteDTO(){

    }
    public IngredienteDTO(long id, String nome, LocalDate scadenza, List<AllergeneDTO> allergeni){
        this.id=id;
        this.nome=nome;
        this.scadenza=scadenza;
        this.allergeni=allergeni;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
