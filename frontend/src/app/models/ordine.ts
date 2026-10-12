import { Carrello } from "./carrello";

export interface Ordine {
    "id":number,
    "username":string,
    "data": string,
    "carrelloDTO":Carrello
}
