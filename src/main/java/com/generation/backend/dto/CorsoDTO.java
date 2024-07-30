package com.generation.backend.dto;

import lombok.Data;

@Data
public class CorsoDTO {
    private Integer id;
    private String nome;
    private String dataInizio;
    private String dataFine;
    private Double prezzo;
    private String descrizione;
    private String img;
    private String orari;
    // private String durata;
    // private Integer numeroMax;
}
