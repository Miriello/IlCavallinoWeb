package com.example.ilcavallinospringversion.service;

import com.example.ilcavallinospringversion.repository.CarrelloRepository;
import org.springframework.stereotype.Service;

@Service
public class CarrelloService {

    private final CarrelloRepository carrelloRepository;

    public CarrelloService(CarrelloRepository carrelloRepository){
        this.carrelloRepository= carrelloRepository;
    }

    public void svuotaCarrello(long id){
        carrelloRepository.clear(id);
    }
}
