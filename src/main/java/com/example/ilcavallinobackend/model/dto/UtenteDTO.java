package com.example.ilcavallinobackend.model.dto;

import com.example.ilcavallinobackend.model.entity.Carrello;
import com.example.ilcavallinobackend.model.entity.Ruolo;

public class UtenteDTO {

    private long id;
    private String username;
    private String email;
    private String password;
    private Ruolo ruolo;
    private Carrello carrello;

}
