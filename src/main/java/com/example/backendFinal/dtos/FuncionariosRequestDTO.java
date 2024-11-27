package com.example.backendFinal.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FuncionariosRequestDTO(
        @NotNull(message = "Nome não pode estar nulo") String nome,
        @NotBlank(message = "Cargo não pode estar vazio") String cargo,
        @NotBlank(message = "Turno não pode estar vazio") String turno
){
}
