package com.generation.backend.dto;

import lombok.Data;

@Data
public class CorsoDTO {
    private Integer id;
    private String nome;
    private String dataInizio;
    private String dataFine;
    private String durata;
    private Integer numeroMax;
    private Double prezzo;
    private String descrizione;
}
