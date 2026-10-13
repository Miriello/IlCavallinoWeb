import { HttpClient } from '@angular/common/http';
import { inject, Service, signal } from '@angular/core';
import { Observable } from 'rxjs';
import { Sessione } from '../models/sessione';
import { LoginRequest } from '../models/loginRequest';
import { RegisterRequest } from '../models/registerRequest';
import { AutenticazioneResponse } from '../models/autenticazioneResponse';

@Service()
export class AutenticazioneService {

    private readonly http = inject(HttpClient);
    private readonly apiUrl = 'http://localhost:8080/api/autenticazione';
    private readonly rispostaCondivisa = signal<AutenticazioneResponse | null> (null);
    readonly statoCondiviso = this.rispostaCondivisa.asReadonly();
    private scadenzaToken = 0;

    constructor() {
        this.ripristinaSessione();
    }

    login(request: LoginRequest): Observable<AutenticazioneResponse> {
        return this.http.post<AutenticazioneResponse>(
            `${this.apiUrl}/login`,
            request
        );
        
    }

    registrazione(request: RegisterRequest): Observable<AutenticazioneResponse> {
        return this.http.post<AutenticazioneResponse>(
            `${this.apiUrl}/registrazione`,
            request
        );
    }

    impostaAutenticazione(risposta: AutenticazioneResponse): void {
        this.scadenzaToken=Date.now() + risposta.expireMs;
        const sessione: Sessione = {
            autenticazione: risposta,
            scadenza: this.scadenzaToken
        };
        localStorage.setItem('sessione', JSON.stringify(sessione));
        this.rispostaCondivisa.set(risposta);
    }

    logout(): void {
        this.rispostaCondivisa.set(null);
        this.scadenzaToken=0;
    }

    tokenValido(): boolean{
        const utente = this.rispostaCondivisa();
        if(!utente || !utente.token){
            return false;
        }
        return Date.now() < this.scadenzaToken;
    }

    ripristinaSessione(): void{
        const dati = localStorage.getItem('sessione');
        if(!dati){return;}
        try{
            const sessione : Sessione = JSON.parse(dati);
            if (!sessione?.autenticazione?.token || !Number.isFinite(sessione.scadenza) || Date.now() >= sessione.scadenza){
                this.logout();
                return;
            }

        this.scadenzaToken = sessione.scadenza;
        this.rispostaCondivisa.set(sessione.autenticazione);

        } catch {
            this.logout();
        }
    }
}