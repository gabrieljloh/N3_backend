package com.example.backendFinal.dtos;

import java.util.UUID;

public record OrdensResponseDTO(
    UUID id,
    String maquina,
    String descricao,
    String status
) {
}
