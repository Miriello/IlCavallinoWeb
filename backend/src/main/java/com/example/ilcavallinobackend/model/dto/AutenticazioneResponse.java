package com.example.ilcavallinobackend.model.dto;

import com.example.ilcavallinobackend.model.entity.Ruolo;

public class AutenticazioneResponse {
    private String token;
    private String username;
    private Ruolo ruolo;
    private long expireMs;

    public AutenticazioneResponse(String token, String username, Ruolo ruolo, long expireMs){
        this.token=token;
        this.username=username;
        this.ruolo=ruolo;
        this.expireMs=expireMs;
    }

    public String getToken(){
        return token;
    }
    public String getUsername(){
        return username;
    }
    public Ruolo getRuolo(){
        return ruolo;
    }

    public long getExpireMs(){
        return expireMs;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public void setExpireMs(long expireMs) {
        this.expireMs = expireMs;
    }
}
