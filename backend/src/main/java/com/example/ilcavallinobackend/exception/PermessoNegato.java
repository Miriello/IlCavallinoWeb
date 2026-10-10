package com.example.ilcavallinobackend.exception;

public class PermessoNegato extends RuntimeException{
    public PermessoNegato(String errore){
        super(errore);
    }
}
