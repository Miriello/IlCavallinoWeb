import { Service } from '@angular/core';
import { Allergene } from '../models/allergene';
import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';
import { Observable } from 'rxjs';

@Service()
export class AllergeneService {
    private readonly http=inject(HttpClient);
    private readonly apiUrl="http://localhost:8080/api/allergeni"

    getAllergeni():Observable<Allergene[]>{
        return this.http.get<Allergene[]>(this.apiUrl);
    }

    getAllergene(id:number):Observable<Allergene>{
        return this.http.get<Allergene>(`${this.apiUrl}/${id}`);
    }

    creaAllergene(allergene: Allergene){
        return this.http.post<Allergene>(this.apiUrl,allergene);
    }

    modificaAllergene(id:number, allergene:Allergene):Observable<Allergene>{ 
        return this.http.put<Allergene>(`${this.apiUrl}/${id}`,allergene);
    }

    eliminaAllergene(id:number):Observable<void>{
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }
}
