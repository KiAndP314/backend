package com.generation.backend.dto;

import lombok.Data;

@Data
public class CorsoDescriptionDTO {
    private Integer id;
    private String nome;
    private String orari;
    private String descrizione;
    private String img;
}
