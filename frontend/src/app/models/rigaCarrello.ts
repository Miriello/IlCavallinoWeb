import { Prodotto } from "./prodotto";

export interface RigaCarrello{
    id: number;
    prodotto: Prodotto;
    quantita: number;
    prezzo: number;
}