package com.example.backendFinal.dtos;

import org.springframework.http.HttpStatus;

public record ErroDTO(
        HttpStatus status,
        String reason
) {
}
