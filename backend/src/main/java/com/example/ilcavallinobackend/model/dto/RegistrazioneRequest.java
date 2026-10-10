package com.example.ilcavallinobackend.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegistrazioneRequest {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @Email
    private String email;

    public RegistrazioneRequest(){

    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    public void setUsername(String username){
        this.username=username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setEmail(String email){
        this.email=email;
    }
}
