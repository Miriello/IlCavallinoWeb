package com.example.ilcavallinobackend.controller;

import com.example.ilcavallinobackend.model.dto.AutenticazioneResponse;
import com.example.ilcavallinobackend.model.dto.LoginRequest;
import com.example.ilcavallinobackend.model.dto.RegistrazioneRequest;
import com.example.ilcavallinobackend.service.AutenticazioneService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AutenticazioneResponse> login (@Valid @RequestBody LoginRequest request){
        return ResponseEntity.ok(autenticazioneService.login(request));
    }

    @PostMapping("/registrazione")
    public ResponseEntity<AutenticazioneResponse> registrazione(@Valid @RequestBody RegistrazioneRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(autenticazioneService.registrazione(request));
    }
}
