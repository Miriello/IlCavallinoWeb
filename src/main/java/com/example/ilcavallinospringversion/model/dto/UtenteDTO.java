package com.example.ilcavallinospringversion.model.dto;

import com.example.ilcavallinospringversion.model.entity.Carrello;
import com.example.ilcavallinospringversion.model.entity.Ruolo;

public class UtenteDTO {

    private long id;
    private String username;
    private String email;
    private String password;
    private Ruolo ruolo;
    private Carrello carrello;

}
