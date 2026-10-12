import { Ruolo } from "./prodotto";

export interface AutenticazioneResponse{
    "token":string,
    "username":string,
    "ruolo": Ruolo,
    "expireMs":number
}