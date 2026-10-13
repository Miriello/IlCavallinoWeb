import { HttpClient } from '@angular/common/http';
import { inject, Service } from '@angular/core';
import { Observable } from 'rxjs';

import { LoginRequest } from '../models/loginRequest';
import { RegisterRequest } from '../models/registerRequest';
import { AutenticazioneResponse } from '../models/autenticazioneResponse';

@Service()
export class AutenticazioneService {

    private readonly http = inject(HttpClient);
    private readonly apiUrl = 'http://localhost:8080/api/autenticazione';

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
}