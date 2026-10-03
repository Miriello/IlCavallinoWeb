package com.example.ilcavallinobackend.controller;

import com.example.ilcavallinobackend.model.dto.LoginRequest;
import com.example.ilcavallinobackend.model.dto.RegistrazioneRequest;
import com.example.ilcavallinobackend.service.AutenticazioneService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autenticazione")
public class AutenticazioneController {
    private final AutenticazioneService autenticazioneService;

    public AutenticazioneController(AutenticazioneService autenticazioneService){
        this.autenticazioneService=autenticazioneService;
    }

    @PostMapping("/login")
    public void login (LoginRequest request){
        autenticazioneService.login(request);
    }

    @PostMapping("/registazione")
    public void registrazione(RegistrazioneRequest request){
        autenticazioneService.registrazione(request);
    }
}
