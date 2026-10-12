import { Ingrediente } from "./ingrediente";

export enum CategoriaProdotto{
    PRIMO = 'PRIMO',
    SECONDO = 'SECONDO',
    CONTORNO = 'CONTORNO',
    ROSTICCERIA = 'ROSTICCERIA',
    BIBITE = 'BIBITE',
    ALCOLICI = 'ALCOLICI'
}

export interface Prodotto {
    "id":number,
    "nome": string,
    "categoriaProdotto": CategoriaProdotto,
    "descrizione":string,
    "prezzo":number,
    "ingredienti":Ingrediente[],
    "urlImg":string
}
