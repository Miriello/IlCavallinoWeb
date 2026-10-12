import { RouterPreloader } from "@angular/router";
import { Ingrediente } from "./ingrediente";

export enum Ruolo{
    USER = 'USER' ,
    ADMIN = 'ADMIN'
} 

export interface Prodotto {
    "id":number,
    "nome": string,
    "categoriaProdotto": Ruolo,
    "descrizione":string,
    "prezzo":number,
    "ingredienti":Ingrediente[],
    "urlImg":string
}
