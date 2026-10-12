import { CurrencyPipe } from "@angular/common";
import { Prodotto } from "./prodotto";

export interface RigaCarrello{
    "prodottoDTO" : Prodotto,
    "unita":number,
    "prezzo": number
}