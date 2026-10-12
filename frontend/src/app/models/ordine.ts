import { Carrello } from "../services/carrello";

export interface Ordine {
    "id":number,
    "username":string,
    "data": Date,
    "carrelloDTO":Carrello
}
