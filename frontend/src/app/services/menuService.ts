import { Service } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { Prodotto } from './prodotto';

@Service()
export class MenuService {
  private elencoProdotti 

  getProdotti(): Observable<Prodotto[]>{
    return this.http.get<Prodotto[]>(this.prodottiUrl);
  }

  getProdotto(id: number): Observable<Prodotto>{
    const url = '${this.prodottiUrl}/${id}';
    return this.http.get<Prodotto>(url);
  }

  updateProdotto(prodotto: prodotto): Observable<any>{
    return this.http.put(this.prodottiUrl, prodotto, httpOptions);
  }

  addProdotto(prodotto: prodotto): Observable<any>{
    return this.http.post(this.prodottiUrl, prodotto, httpOptions);
  }



  const httpOptions = {
    headers: new HttpHeaders({'Content-type' : 'application/json'}) 
  };
}
