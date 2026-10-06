package com.example.ilcavallinobackend.security;

import com.example.ilcavallinobackend.repository.UtenteRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UtenteDetailsService implements UserDetailsService {

    private UtenteRepository utenteRepository;

    public UtenteDetailsService(UtenteRepository utenteRepository){
        this.utenteRepository=utenteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return utenteRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Utente non trovato"));
    }

}
