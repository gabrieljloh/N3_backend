package com.example.backendFinal.mappers;

import com.example.backendFinal.dtos.MaquinasResponseDTO;
import com.example.backendFinal.models.MaquinasModel;
import org.springframework.stereotype.Component;

@Component
public class MaquinasMapper {
    public MaquinasResponseDTO toDto(MaquinasModel maquinas){
        return new MaquinasResponseDTO(
                maquinas.getId(),
                maquinas.getModelo(),
                maquinas.getOperador().getNome(),
                maquinas.getStatus()
        );
    }
}
