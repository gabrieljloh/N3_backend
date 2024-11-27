package com.example.backendFinal.services;

import com.example.backendFinal.dtos.OrdensRequestDTO;
import com.example.backendFinal.dtos.OrdensResponseDTO;
import com.example.backendFinal.mappers.OrdensMapper;
import com.example.backendFinal.models.OrdensModel;
import com.example.backendFinal.repositories.OrdensRepository;
import com.example.backendFinal.models.MaquinasModel;
import com.example.backendFinal.models.FuncionariosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrdensService {

    @Autowired
    private OrdensRepository ordensRepository;

    @Autowired
    private OrdensMapper ordensMapper;

    // Salvar uma nova ordem de serviço
    public OrdensResponseDTO save(OrdensRequestDTO ordensRequest) {
        OrdensModel ordens = new OrdensModel();
        ordens.setDescricao(ordensRequest.descricao()); // Corrigido para acessar diretamente o campo
        ordens.setStatus("Aberta"); // Pode ser um valor padrão ou vir do DTO
        // Preencher a máquina e funcionário com base nos dados recebidos
        ordens.setMaquina(new MaquinasModel()); // Preencher corretamente com base no DTO ou na lógica do seu projeto
        ordens.setFuncionarioResp(new FuncionariosModel()); // Preencher corretamente com base no DTO ou na lógica do seu projeto
        OrdensModel savedOrdem = ordensRepository.save(ordens);
        return ordensMapper.toDto(savedOrdem);
    }

    // Buscar todas as ordens de serviço
    public List<OrdensResponseDTO> findAll() {
        List<OrdensModel> ordens = ordensRepository.findAll();
        return ordens.stream()
                .map(ordensMapper::toDto)
                .toList();
    }

    // Buscar ordem de serviço por ID
    public OrdensResponseDTO findById(UUID id) {
        OrdensModel ordens = ordensRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada"));
        return ordensMapper.toDto(ordens);
    }

    // Deletar uma ordem de serviço por ID
    public void delete(UUID id) {
        ordensRepository.deleteById(id);
    }
}
