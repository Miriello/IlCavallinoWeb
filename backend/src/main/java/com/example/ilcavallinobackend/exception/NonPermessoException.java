package com.example.ilcavallinobackend.exception;

public class NonPermessoException extends RuntimeException {

    public NonPermessoException(String errore){
        super(errore);
    }
}
