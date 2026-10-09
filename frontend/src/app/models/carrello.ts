import { Prodotto } from "./prodotto";
import { RigaCarrello } from "./rigaCarrello";

export interface Carrello {
    id: number;
    righeCarrello: RigaCarrello[];
    utente: string;
}