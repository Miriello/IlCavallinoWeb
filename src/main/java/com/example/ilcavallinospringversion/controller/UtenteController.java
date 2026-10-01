package com.example.ilcavallinospringversion.controller;

import com.example.ilcavallinospringversion.model.dto.UtenteDTO;
import com.example.ilcavallinospringversion.service.UtenteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/utenti")
public class UtenteController {
    private final UtenteService utenteService;

    public UtenteController(UtenteService utenteService){
        this.utenteService=utenteService;
    }
    @RequestMapping
    public UtenteDTO getUtente(){
        return null;
    }
}
