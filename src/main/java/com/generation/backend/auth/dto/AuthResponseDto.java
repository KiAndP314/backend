package com.generation.backend.auth.dto;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String accessToken;
    private String tokenType = "Bearer ";
    private Integer id;

    public AuthResponseDto(String accessToken, Integer id) 
    {
        this.accessToken = accessToken;
        this.id = id;
    }
}
