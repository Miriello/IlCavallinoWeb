import { Utente } from './utente';
import { Carrello } from './carrello';

export interface Ordine {
    id: number;
    utente: string;
    data: Date;
    carrello: Carrello;
}