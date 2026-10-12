export enum Ruolo{
    USER = 'USER' ,
    ADMIN = 'ADMIN'
} 

export interface AutenticazioneResponse{
    "token":string,
    "username":string,
    "ruolo": Ruolo,
    "expireMs":number
}