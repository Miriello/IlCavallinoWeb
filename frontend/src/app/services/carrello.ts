import { HttpClient } from '@angular/common/http';
import { Injectable, inject, Service } from '@angular/core';
import { RigaCarrello } from '../models/rigaCarrello';
import { Carrello } from '../models/carrello';
import { Observable } from 'rxjs';

@Service()
export class CarrelloService {
    private readonly http = inject(HttpClient);
    private readonly apiUrl= 'http://localhost:8080/api/carrello';

    getCarrello():Observable<Carrello>{
        return this.http.get<Carrello>(this.apiUrl);
    }

    aggiungiAlCarrello(id:number, quantita:number):Observable<Carrello>{
        return this.http.post<Carrello>(`${this.apiUrl}/${id}`);
    }
}
