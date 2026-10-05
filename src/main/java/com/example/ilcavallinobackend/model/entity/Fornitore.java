package com.example.ilcavallinobackend.model.entity;

import jakarta.persistence.*;


@Entity
@Table(name="fornitori")
public class Fornitore {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String partitaIva;
    @Column(nullable = false)
    private String ragioneSociale;
    @Column(nullable = false)
    private String email;

    public Fornitore(){

    }

    public Fornitore(long id, String partitaIva, String ragioneSociale, String email){
        this.id=id;
        this.partitaIva=partitaIva;
        this.ragioneSociale=ragioneSociale;
        this.email=email;
    }

    public long getId(){
        return id;
    }

    public String getPartitaIva(){
        return partitaIva;
    }

    public String getRagioneSociale(){
        return ragioneSociale;
    }

    public String getEmail(){
        return email;
    }

    public void setId(long id){
        this.id=id;
    }
    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }
    public void setRagioneSociale(String ragioneSociale){
        this.ragioneSociale=ragioneSociale;
    }
    public void setEmail(String email){
        this.email=email;
    }
}
