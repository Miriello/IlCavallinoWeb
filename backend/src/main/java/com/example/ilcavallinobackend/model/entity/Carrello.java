package com.example.ilcavallinobackend.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="carrello")
public class Carrello {

    @Id
    @GeneratedValue
    private long id;
    @OneToMany(cascade =CascadeType.ALL, orphanRemoval = true)
    private List<RigaCarrello> elenco = new ArrayList<>();
    @OneToOne(mappedBy = "carrello")
    private Utente utente;


    public Carrello(){

    }

    public long getId(){
        return id;
    }

    public List<RigaCarrello> getElenco(){
        return elenco;
    }

    public Utente getUtente(){
        return utente;
    }

    public double getTotale(){
        double totale = 0.0;
        for(RigaCarrello rg : elenco){
            int unita = rg.getUnita();
            double prezzo = rg.getPrezzo();
            totale += unita*prezzo;
        }
        return totale;
    }

    public void aggiungiRiga(RigaCarrello rg){
        this.elenco.add(rg);
    }

    public void rimuoviRiga(int indice){
        this.elenco.remove(indice);
    }

    public void rimuoviRiga(Prodotto p){
        int indice = 0;
        for(RigaCarrello rg : elenco){
            if(rg.getProdotto().getId() == p.getId()){
                rimuoviRiga(indice);
                break;
            }
            indice++;
        }
    }

    public boolean prodottoPresente(Prodotto prodotto){
        for(RigaCarrello rg : elenco){
            if(rg.getProdotto().getId() == prodotto.getId()){
                return true;
            }
        }
        return false;
    }

    public void modificaQuantita(Prodotto prodotto, int nuovaQuantita){
        if(nuovaQuantita < 0){
            throw new IllegalArgumentException("La quantità non può essere negativa");
        }
        if(nuovaQuantita == 0){
            rimuoviRiga(prodotto);
        }
        else {
            for (RigaCarrello rg : elenco) {
                if (rg.getProdotto().getId() == prodotto.getId()) {
                    rg.setUnita(nuovaQuantita);
                }
            }
        }
    }

    public void modificaPrezzo(Prodotto prodotto, double nuovoPrezzo){
        if(nuovoPrezzo <= 0){
            throw new IllegalArgumentException("Il prezzo non può essere negativo");
        }
        for(RigaCarrello rg: elenco){
            if(rg.getProdotto().getId()== prodotto.getId()){
                rg.setPrezzo(nuovoPrezzo);
            }
        }
    }

    public int getQuantitaProdotto(Prodotto prodotto){
        for(RigaCarrello rg: elenco){
            if(rg.getProdotto().getId()==prodotto.getId()){
                return rg.getUnita();
            }
        }
        return 0;
    }


    public void setId(long id){
        this.id=id;
    }

    public void setElenco(List<RigaCarrello> elenco){
        this.elenco=elenco;
    }

    public void setUtente(Utente utente){
        this.utente=utente;
    }

}
