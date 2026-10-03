package com.example.ilcavallinospringversion.model.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ingredienti")
public class Ingrediente {

        @Id
        @GeneratedValue
        private long id;

        private String nome;
        private LocalDate scadenza;
        @OneToMany
        private List<Allergene> allergeni;


        public Ingrediente(String nome, LocalDate scadenza, List<Allergene> allergeni, int id) {
            this.nome = nome;
            this.scadenza = scadenza;
            this.allergeni= new ArrayList<>(allergeni);
            this.id=id;
        }

        public Ingrediente() {
        }

        public String getNome() {
            return nome;
        }

        public LocalDate getScadenza() {
            return scadenza;
        }

        public List<Allergene> getAllergeni() {
            return new ArrayList<>(allergeni);
        }

        public long getId(){
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public void setNome(String nome) {
        this.nome = nome;
        }

        public void setScadenza(LocalDate scadenza) {
            this.scadenza = scadenza;
        }

        public void setAllergeni(List<Allergene> allergeni) {
            this.allergeni = allergeni;
        }
}

