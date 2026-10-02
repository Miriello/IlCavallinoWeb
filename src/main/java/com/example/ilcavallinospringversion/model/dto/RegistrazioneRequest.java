package com.example.ilcavallinospringversion.model.dto;

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
    @NotBlank
    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }


    public String getEmail(){
        return password;
    }
}
