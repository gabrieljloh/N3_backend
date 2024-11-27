package com.example.backendFinal.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record OrdensRequestDTO(
        @NotNull(message = "Máquina não pode estar nulo") String maquina,
        @NotBlank(message = "Funcionáro não pode estar vazio") String funcionarioResp,
        @NotBlank(message = "Adicione ao menos um caractere a descrição.") String descricao

) {
}
