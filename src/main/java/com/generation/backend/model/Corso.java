package com.generation.backend.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Corso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String dataInizio; // 
    private String dataFine;   // 
    private Double prezzo;
    private String descrizione;
    private String img;
    private String orari;
    // private Integer numeroMax;
    // private String durata;
    // private String orari;

    @ManyToOne
    @JoinColumn(name = "palestra_id")
    private Palestra palestra;

    @OneToMany(mappedBy = "corso")
    private List<Abbonamento> abbonamenti = new ArrayList<>();


}
