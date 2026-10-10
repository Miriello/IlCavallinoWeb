package com.example.ilcavallinobackend.service;

import com.example.ilcavallinobackend.model.dto.AutenticazioneResponse;
import com.example.ilcavallinobackend.model.dto.LoginRequest;
import com.example.ilcavallinobackend.model.dto.RegistrazioneRequest;
import com.example.ilcavallinobackend.model.entity.Carrello;
import com.example.ilcavallinobackend.model.entity.Ruolo;
import com.example.ilcavallinobackend.model.entity.Utente;
import com.example.ilcavallinobackend.repository.CarrelloRepository;
import com.example.ilcavallinobackend.repository.UtenteRepository;
import com.example.ilcavallinobackend.security.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AutenticazioneService {
    private final UtenteRepository utenteRepository;
    private final CarrelloRepository carrelloRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Value("600")
    private long jwtExpirationMs;

    public AutenticazioneService(UtenteRepository utenteRepository,
                                 CarrelloRepository carrelloRepository,
                                 PasswordEncoder passwordEncoder,
                                 AuthenticationManager authenticationManager,
                                 JwtService jwtService){
        this.utenteRepository=utenteRepository;
        this.carrelloRepository=carrelloRepository;
        this.passwordEncoder=passwordEncoder;
        this.authenticationManager=authenticationManager;
        this.jwtService=jwtService;
    }

    public AutenticazioneResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        Utente utente = utenteRepository.findByUsername(request.getUsername()).orElseThrow();

        String token = jwtService.generaToken(claimsConRuolo(utente), utente);

        return new AutenticazioneResponse(token, utente.getUsername(), utente.getRuolo(), jwtExpirationMs);
    }

    public AutenticazioneResponse registrazione(RegistrazioneRequest request ){
        if(utenteRepository.existByUsername(request.getUsername())){
            throw new IllegalArgumentException("Username già presente");
        }
        if(utenteRepository.existByEmail(request.getEmail())){
            throw new IllegalArgumentException("Email già presente");
        }
        Utente utente = new Utente(request.getUsername(),request.getPassword(),passwordEncoder.encode(request.getPassword()), Ruolo.USER);
        utenteRepository.save(utente);
        carrelloRepository.save(new Carrello());
        String token = jwtService.generaToken(claimsConRuolo(utente), utente);
        return new AutenticazioneResponse(token, utente.getUsername(), utente.getRuolo(), jwtExpirationMs);
    }

    public Map<String, Object> claimsConRuolo(Utente utente){
        Map<String, Object> extra = new HashMap<>();
        extra.put("ruolo", utente.getRuolo().name());
        return extra;
    }
}
