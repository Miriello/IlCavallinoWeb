package com.example.ilcavallinobackend.controller;

import com.example.ilcavallinobackend.model.dto.LoginRequest;
import com.example.ilcavallinobackend.model.dto.RegistrazioneRequest;
import com.example.ilcavallinobackend.service.AutenticazioneService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autenticazione")
public class AuthController {
    private final AutenticazioneService autenticazioneService;

    public AuthController(AutenticazioneService autenticazioneService){
        this.autenticazioneService=autenticazioneService;
    }

    @PostMapping("/login")
    public void login (@RequestBody LoginRequest request){
        autenticazioneService.login(request);
    }

    @PostMapping("/registazione")
    public void registrazione(@RequestBody RegistrazioneRequest request){
        autenticazioneService.registrazione(request);
    }
}
