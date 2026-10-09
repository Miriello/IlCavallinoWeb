import { Injectable , inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Prodotto } from '../models/prodotto';

@Injectable({
    providedIn:'root'
})

export class ProdottoService{
    private http = inject(HttpClient);
    private apiUrl = 'http://localhost:8080/api/prodotti';

    getProdotti(): Observable<Prodotto[]> {
        return this.http.get<Prodotto[]>(this.apiUrl);
    }

    getProdotto(id: number): Observable<Prodotto> {
  return this.http.get<Prodotto>(
    `${this.apiUrl}/${id}`
  );
    }
}