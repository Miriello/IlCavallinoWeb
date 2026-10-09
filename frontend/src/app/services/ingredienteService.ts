import { Service } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { Ingrediente } from './ingrediente'

@Service()
export class IngredienteService {
  private elencoIngredienti[] ;

  getIngredienti(idProdotto: number): Observable<Ingrediente[]>{
    return this.http.get<Ingrediente[]>(this.ingredientiUrl[]);
  }

  updateIngrediente(i: prodotto): Observable<any>{
    return this.http.put(this.prodottiUrl, prodotto, httpOptions);
  }

  addProdotto(prodotto: prodotto): Observable<any>{
    return this.http.post(this.prodottiUrl, prodotto, httpOptions);
  }



  const httpOptions = {
    headers: new HttpHeaders({'Content-type' : 'application/json'}) 
  };
}
