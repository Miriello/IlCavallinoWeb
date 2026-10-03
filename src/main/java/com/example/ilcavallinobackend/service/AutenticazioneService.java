package com.example.ilcavallinobackend.service;

import com.example.ilcavallinobackend.model.dto.LoginRequest;
import com.example.ilcavallinobackend.model.dto.RegistrazioneRequest;
import com.example.ilcavallinobackend.repository.UtenteRepository;
import org.springframework.stereotype.Service;

@Service
public class AutenticazioneService {
    private UtenteRepository utenteRepository;

    public AutenticazioneService(UtenteRepository utenteRepository){
        this.utenteRepository=utenteRepository;
    }

    public boolean login (LoginRequest request){
        return false;
    }

    public boolean registrazione(RegistrazioneRequest request ){
        return false;
    }
}
