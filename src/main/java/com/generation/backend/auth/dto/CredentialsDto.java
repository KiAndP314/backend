package com.generation.backend.auth.dto;


import lombok.Data;

@Data
public class CredentialsDto {
    private String email;
    private String password;
}
