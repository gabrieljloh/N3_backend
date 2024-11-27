package com.example.backendFinal.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MaquinasRequestDTO(
        @NotNull(message = "Nome não pode estar vazio") String nome,
        @NotBlank(message = "Modelo não pode estar vazio") String modelo,
        @NotBlank(message = "Fabricante não pode estar vazio") String fabricante,
        @NotBlank(message = "Status não pode estar vazio") String status
) {
}
