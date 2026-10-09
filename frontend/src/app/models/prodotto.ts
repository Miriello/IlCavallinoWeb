import { Ingrediente } from "../components/ingrediente/ingrediente";

export interface Prodotto {
    id: number;
    nome: string;
    descrizione: string;
    categoriaProdotto: Enumerator;
    prezzo: number;
    ingredienti: Ingrediente[];
    immagineUrl: string;
}