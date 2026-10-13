import { AutenticazioneResponse } from "./autenticazioneResponse";

export interface Sessione{
    autenticazione: AutenticazioneResponse;
    scadenza: number;
}