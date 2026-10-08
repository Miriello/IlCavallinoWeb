package com.example.ilcavallinobackend.controller;

import com.example.ilcavallinobackend.model.dto.UtenteDTO;
import com.example.ilcavallinobackend.service.UtenteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/utenti")
public class UtenteController {
    private final UtenteService utenteService;

    public UtenteController(UtenteService utenteService){
        this.utenteService=utenteService;
    }

    @GetMapping
    public UtenteDTO getUtente(){
        return null;
    }
}
