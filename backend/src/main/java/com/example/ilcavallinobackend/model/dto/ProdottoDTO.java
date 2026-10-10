package com.example.ilcavallinobackend.model.dto;

import com.example.ilcavallinobackend.model.entity.CategoriaProdotto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ProdottoDTO {

    private long id;
    @NotBlank
    private String nome;
    @NotNull
    private CategoriaProdotto categoriaProdotto;
    private String descrizione;
    @DecimalMin("0,01")
    private double prezzo;
    private List<IngredienteDTO> ingredienti;
    private String urlImg;


    public ProdottoDTO(long id, String nome, CategoriaProdotto categoriaProdotto, String descrizione, double prezzo, List<IngredienteDTO> ingredienti, String urlImg){
        this.id=id;
        this.nome=nome;
        this.categoriaProdotto=categoriaProdotto;
        this.descrizione=descrizione;
        this.prezzo=prezzo;
        this.ingredienti=ingredienti;
        this.urlImg=urlImg;
    }

    public ProdottoDTO() {

    }

    public long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public CategoriaProdotto getCategoriaProdotto(){
        return categoriaProdotto;
    }

    public String getDescrizione(){
        return descrizione;
    }

    public double getPrezzo(){
        return prezzo;
    }

    public List<IngredienteDTO> getIngredienti(){
        return ingredienti;
    }

    public String getUrlImg(){
        return urlImg;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoriaProdotto(CategoriaProdotto categoriaProdotto) {
        this.categoriaProdotto = categoriaProdotto;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setIngredienti(List<IngredienteDTO> ingredienti) {
        this.ingredienti = ingredienti;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}
