package com.example.ilcavallinospringversion.service;

import com.example.ilcavallinospringversion.repository.CarrelloRepository;
import org.springframework.stereotype.Service;

@Service
public class CarrelloService {

    private static CarrelloRepository carrelloRepository;

    public CarrelloService(CarrelloRepository carrelloRepository){
        this.carrelloRepository= carrelloRepository;
    }

    public static void svuotaCarrello(long id){
        carrelloRepository.delete(id);
    }
}
