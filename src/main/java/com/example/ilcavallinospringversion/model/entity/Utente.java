package com.example.ilcavallinospringversion.model.entity;

import com.example.ilcavallinospringversion.repository.CarrelloRepository;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="utenti")
public class Utente implements UserDetails {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Ruolo ruolo;
    @OneToOne
    private Carrello carrello;

    public Utente(){

    }

    public Utente (String username, String password, String email, Ruolo ruolo){
        this.username=username;
        this.password=password;
        this.email=email;
        this.ruolo=ruolo;
    }

    @Override
    public String getUsername(){
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("Ruolo: " + ruolo.name()));
    }

    @Override
    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    public Ruolo getRuolo(){
        return ruolo;
    }

    public long getId(){
        return id;
    }

    public Carrello getCarrello(){
        return carrello;
    }


    public void setId(long id){
        this.id=id;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public void setRuolo(Ruolo ruolo){
        this.ruolo=ruolo;
    }

    public void setCarrello(Carrello carrello){
        this.carrello=carrello;
    }
}
