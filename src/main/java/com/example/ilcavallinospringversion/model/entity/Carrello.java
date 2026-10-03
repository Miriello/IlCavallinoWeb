package com.example.ilcavallinospringversion.model.entity;

import com.example.ilcavallinospringversion.utility.RigaCarrello;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="carrello")
public class Carrello {

    @Id
    @GeneratedValue
    private long id;
    private List<RigaCarrello> elenco;
    @OneToOne(optional = false)
    @JoinColumn(name="utente_id", nullable = false, unique = true)
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
            indice++;
            if(rg.getProdotto() == p){
                rimuoviRiga(indice);
            }
        }
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
                if (rg.getProdotto() == prodotto) {
                    rg.setUnita(nuovaQuantita);
                }
            }
        }
    }

    public void modificaPrezzo(Prodotto prodotto, double nuovoPrezzo){
        for(RigaCarrello rg: elenco){
            if(rg.getProdotto()== prodotto){
                rg.setPrezzo(nuovoPrezzo);
            }
        }
    }

    public void setId(long id){
        this.id=id;
    }

    public void setElenco(List<RigaCarrello> Elenco){
        this.elenco=elenco;
    }

    public void setUtente(Utente utente){
        this.utente=utente;
    }

}
