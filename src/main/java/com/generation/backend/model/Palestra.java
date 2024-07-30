package com.generation.backend.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Palestra {
    // List<Lezione> lezioni =  new ArrayList<>()
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String indirizzo;

    @OneToMany(mappedBy = "palestra")
    private List<Corso> corsi = new ArrayList<>();

    @OneToMany(mappedBy = "palestra")
    private List<Abbonamento> abbonamenti = new ArrayList<>();

    // @OneToMany(mappedBy = "palestra")
    // private List<UserAdditionalInfo> users = new ArrayList<>();
    
}
