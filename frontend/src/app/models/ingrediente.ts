import { Allergene } from './allergene';

export interface Ingrediente {
    id: number;
    nome: string; 
    allergeni: Allergene[];
    scadenza: Date;
}
