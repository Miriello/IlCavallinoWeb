import { Prodotto } from "./prodotto";

export interface RigaCarrello{
    "prodottoDTO" : Prodotto,
    "unita":number,
    "prezzo": number
}