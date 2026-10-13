import { inject } from "@angular/core";
import { HttpInterceptorFn } from "@angular/common/http";
import { AutenticazioneService } from "../services/autenticazione";

export const jwtInterceptor: HttpInterceptorFn = (req,next) => {
    const autenticazioneService = inject(AutenticazioneService);
    const autenticazione = autenticazioneService.statoCondiviso();
    const token = autenticazione?.token;
    const richiestaSenzaHeader = req.url.startsWith('http://localhost:8080/api/autenticazione/');
    const richiestaBackend = req.url.startsWith('http://localhost:8080/api/');

    if(!token || !autenticazioneService.tokenValido() || richiestaSenzaHeader || !richiestaBackend){
        return next(req);
    }

    const richiestaConHeader = req.clone({
        setHeaders:{
            Authorization:`Bearer ${token}`
        }
    });

    return next(richiestaConHeader);
}