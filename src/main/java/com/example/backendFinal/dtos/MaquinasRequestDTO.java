package com.example.backendFinal.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record MaquinasRequestDTO(
        @NotNull(message = "Nome não pode estar nulo") String nome,
        @NotBlank(message = "Operador não pode estar vazio") String operador

) {
}
