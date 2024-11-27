package com.example.backendFinal.mappers;

import com.example.backendFinal.dtos.OrdensResponseDTO;
import com.example.backendFinal.models.OrdensModel;
import org.springframework.stereotype.Component;

@Component
public class OrdensMapper {
    public OrdensResponseDTO toDto(OrdensModel ordens) {
        return new OrdensResponseDTO(
                ordens.getId(),
                ordens.getMaquina().getNome(),
                ordens.getDescricao(),
                ordens.getStatus()
        );
    }
}
