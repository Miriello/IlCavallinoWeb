package com.example.ilcavallinobackend.service;

import com.example.ilcavallinobackend.exception.NonPermessoException;
import com.example.ilcavallinobackend.model.dto.AutenticazioneResponse;
import com.example.ilcavallinobackend.model.dto.LoginRequest;
import com.example.ilcavallinobackend.model.dto.RegistrazioneRequest;
import com.example.ilcavallinobackend.model.entity.Carrello;
import com.example.ilcavallinobackend.model.entity.Ruolo;
import com.example.ilcavallinobackend.model.entity.Utente;
import com.example.ilcavallinobackend.repository.CarrelloRepository;
import com.example.ilcavallinobackend.repository.UtenteRepository;
import com.example.ilcavallinobackend.security.JwtService;
import jakarta.transaction.Transactional;
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
    @Value("${application.security.jwt.expiration-ms}")
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

    @Transactional
    public AutenticazioneResponse registrazione(RegistrazioneRequest request ){
        if(utenteRepository.existsByUsername(request.getUsername())){
            throw new NonPermessoException("Username già presente");
        }
        if(utenteRepository.existsByEmail(request.getEmail())){
            throw new NonPermessoException("Email già presente");
        }
        Utente utente = new Utente(request.getUsername(),passwordEncoder.encode(request.getPassword()),request.getEmail(), Ruolo.USER);
        Carrello carrello = carrelloRepository.save(new Carrello());
        utente.setCarrello(carrello);
        utenteRepository.save(utente);
        String token = jwtService.generaToken(claimsConRuolo(utente), utente);
        return new AutenticazioneResponse(token, utente.getUsername(), utente.getRuolo(), jwtExpirationMs);
    }

    public Map<String, Object> claimsConRuolo(Utente utente){
        Map<String, Object> extra = new HashMap<>();
        extra.put("ruolo", utente.getRuolo().name());
        return extra;
    }
}
