package com.example.backendFinal.mappers;


import com.example.backendFinal.dtos.FuncionariosResponseDTO;
import com.example.backendFinal.models.FuncionariosModel;
import org.springframework.stereotype.Component;

@Component
public class FuncionariosMapper {
    public FuncionariosResponseDTO toDto(FuncionariosModel funcionario){
        return new FuncionariosResponseDTO(
                funcionario.getId(),
                funcionario.getCargo(),
                funcionario.getTurno(),
                funcionario.getStatus()
        );
    }
}
