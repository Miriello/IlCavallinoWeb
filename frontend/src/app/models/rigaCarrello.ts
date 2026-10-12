import { CurrencyPipe } from "@angular/common";
import { Prodotto } from "../services/prodotto";

export interface RigaCarrello{
    "prodottoDTO" : Prodotto,
    "unita":number,
    "prezzo": number
}