package com.generation.backend.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UtenteDTO {
    private String email;
    private String nome;
    private String cognome;
    private String dob;
    private Boolean certificato;

    private List<AbbonamentoDTO> abbonamenti = new ArrayList<>();

    // private String nomePalestra;
    // private List<String> nomiCorsi;

    // private List<CorsoDTO> corsi = new ArrayList<>();
}
