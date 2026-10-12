import { HttpClient } from '@angular/common/http';
import { inject, Service } from '@angular/core';
import { Observable } from 'rxjs';
import { Prodotto } from '../models/prodotto';

@Service()
export class ProdottoService {
    private readonly http=inject(HttpClient);
    private readonly apiUrl= 'http://localhost:8080/api/prodotti';

    getProdotti(): Observable<Prodotto[]>{
        return this.http.get<Prodotto[]>(this.apiUrl);
    }

    getProdotto(id:number): Observable<Prodotto>{
        return this.http.get<Prodotto>(`${this.apiUrl}/${id}`);
    }

    creaProdotto(prodotto: Prodotto): Observable<Prodotto>{
        return this.http.post<Prodotto>(this.apiUrl,prodotto);
    }

    modificaProdotto(id:number, prodotto:Prodotto):Observable<Prodotto>{
        return this.http.put<Prodotto>(`${this.apiUrl}/${id}`, prodotto);
    }

    eliminaProdotto(id:number):Observable<void>{
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }
}
