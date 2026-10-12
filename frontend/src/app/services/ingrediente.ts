import { HttpClient } from '@angular/common/http';
import { Service } from '@angular/core';
import { Observable } from 'rxjs';
import { Ingrediente } from '../models/ingrediente';
import { inject } from '@angular/core';

@Service()
export class IngredienteService {
    private readonly http= inject(HttpClient);
    private readonly apiUrl='http://localhost:8080/api/ingredienti';

    getIngredienti():Observable<Ingrediente[]>{
        return this.http.get<Ingrediente[]>(this.apiUrl);
    }

    getIngrediente(id:number):Observable<Ingrediente>{
        return this.http.get<Ingrediente>('${this.apiUrl}/${id}');
    }


    creaIngrediente(ingrediente:Ingrediente): Observable<Ingrediente>{
        return this.http.post<Ingrediente>(this.apiUrl,ingrediente);
    }

    modificaIngrediente(id:number, ingrediente:Ingrediente):Observable<Ingrediente>{
        return this.http.put<Ingrediente>('${this.apiUrl}/${id}',ingrediente);
    }

    eliminaIngrediente(id:number):Observable<void>{
        return this.http.delete<void>('${this.apiUrl}/${id}');
    }
}
