package com.example.ilcavallinospringversion.controller;

import com.example.ilcavallinospringversion.model.requestDTO.LoginRequest;
import com.example.ilcavallinospringversion.model.requestDTO.RegistrazioneRequest;
import com.example.ilcavallinospringversion.service.AutenticazioneService;
import jakarta.persistence.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
