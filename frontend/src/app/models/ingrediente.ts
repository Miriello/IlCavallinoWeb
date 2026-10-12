import { Allergene } from "../services/allergene";

export interface Ingrediente {
    "id":number;
    "nome":string,
    "scadenza":Date,
    "allergeni": Allergene[]
}
