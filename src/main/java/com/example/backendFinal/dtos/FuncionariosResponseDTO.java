package com.example.backendFinal.dtos;

import java.util.UUID;

public record FuncionariosResponseDTO(
        UUID id,
        String cargo,
        String turno,
        String status
) {
}
