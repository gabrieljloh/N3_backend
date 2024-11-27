package com.example.backendFinal.services;

import com.example.backendFinal.dtos.MaquinasRequestDTO;
import com.example.backendFinal.dtos.MaquinasResponseDTO;
import com.example.backendFinal.mappers.MaquinasMapper;
import com.example.backendFinal.models.MaquinasModel;
import com.example.backendFinal.repositories.MaquinasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MaquinasService {

    @Autowired
    private MaquinasRepository maquinasRepository;

    @Autowired
    private MaquinasMapper maquinasMapper;

    // Salvar uma nova máquina
    public MaquinasResponseDTO save(MaquinasRequestDTO maquinaRequest) {
        MaquinasModel maquina = new MaquinasModel();
        maquina.setNome(maquinaRequest.nome());
        maquina.setModelo(maquinaRequest.modelo());
        maquina.setFabricante(maquinaRequest.fabricante());
        maquina.setStatus(maquinaRequest.status());
        MaquinasModel savedMaquina = maquinasRepository.save(maquina);
        return maquinasMapper.toDto(savedMaquina);
    }

    // Buscar todas as máquinas
    public List<MaquinasResponseDTO> findAll() {
        List<MaquinasModel> maquinas = maquinasRepository.findAll();
        return maquinas.stream()
                .map(maquinasMapper::toDto)
                .toList();
    }

    // Buscar máquina por ID
    public MaquinasResponseDTO findById(UUID id) {
        MaquinasModel maquina = maquinasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Máquina não encontrada"));
        return maquinasMapper.toDto(maquina);
    }

    // Deletar uma máquina por ID
    public void delete(UUID id) {
        maquinasRepository.deleteById(id);
    }
}
