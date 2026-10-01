package com.example.ilcavallinospringversion.model.requestDTO;

import com.example.ilcavallinospringversion.model.entity.Carrello;
import com.example.ilcavallinospringversion.model.entity.Ruolo;
import com.example.ilcavallinospringversion.model.entity.Utente;
import com.example.ilcavallinospringversion.service.CarrelloService;

public class UtenteRequest {

    private long id;
    private String username;
    private String email;
    private String password;
    private Ruolo ruolo;
    private Carrello carrello;

    public UtenteRequest(){

    }

    public UtenteRequest(long id, String username, String email, String password, Ruolo ruolo, Carrello carrello){
        this.id=id;
        this.username=username;
        this.email=email;
        this.password=password;
        this.ruolo=ruolo;
        this.carrello=carrello;
    }

    public Utente toEntity(){
        Utente utente = new Utente();
        utente.setId(this.id);
        utente.setUsername(this.username);
        utente.setEmail(this.email);
        utente.setPassword(this.password);
        utente.setRuolo(this.ruolo);
        utente.setCarrello(this.carrello);
        return utente;
    }
}
