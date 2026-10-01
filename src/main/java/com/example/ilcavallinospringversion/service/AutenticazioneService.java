package com.example.ilcavallinospringversion.service;

import com.example.ilcavallinospringversion.model.requestDTO.LoginRequest;
import com.example.ilcavallinospringversion.model.requestDTO.RegistrazioneRequest;
import com.example.ilcavallinospringversion.repository.UtenteRepository;
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
