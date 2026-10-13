import { HttpClient } from '@angular/common/http';
import { Service } from '@angular/core';
import { inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Ordine } from '../models/ordine';

@Service()
export class OrdineService {
    private readonly http = inject(HttpClient);
    private readonly apiUrl = 'http://localhost:8080/api/ordini';

    getOrdini():Observable<Ordine[]>{
        return this.http.get<Ordine[]>(this.apiUrl);
    }

    getOrdine(id:number):Observable<Ordine>{
        return this.http.get<Ordine>(`${this.apiUrl}/${id}`);
    }

    getMieiOrdini(): Observable<Ordine[]> {
        return this.http.get<Ordine[]>(`${this.apiUrl}/miei`);
    }

    creaOrdine(): Observable<Ordine> {
        return this.http.post<Ordine>(this.apiUrl, null);
    }

    eliminaOrdine(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }

}
