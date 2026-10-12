import { RouterPreloader } from "@angular/router";
import { Ingrediente } from "../services/ingrediente";

export enum Ruolo{
    USER = 'USER' ,
    ADMIN = 'ADMIN'
} 

export interface Prodotto {
    "id":number,
    "nome": string,
    "categoriaProdotto": Ruolo
}
