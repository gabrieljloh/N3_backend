package com.example.backendFinal.dtos;

import java.util.UUID;

public record MaquinasResponseDTO(
        UUID id,
        String modelo,
        String operador,
        String status
) {
}
