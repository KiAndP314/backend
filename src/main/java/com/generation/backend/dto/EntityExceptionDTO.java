package com.generation.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntityExceptionDTO 
{
    private String message;
    private String entityType;
}
