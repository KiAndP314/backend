package com.generation.backend.auth.dto;

import lombok.Data;

@Data
public class FullCredentialDTO {
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private String dob;
}
