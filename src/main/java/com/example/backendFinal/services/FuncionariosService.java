package com.example.backendFinal.services;

import com.example.backendFinal.dtos.FuncionariosRequestDTO;
import com.example.backendFinal.dtos.FuncionariosResponseDTO;
import com.example.backendFinal.mappers.FuncionariosMapper;
import com.example.backendFinal.models.FuncionariosModel;
import com.example.backendFinal.repositories.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FuncionariosService {

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @Autowired
    private FuncionariosMapper funcionariosMapper;

    // Salvar um novo funcionário
    public FuncionariosResponseDTO save(FuncionariosRequestDTO funcionarioRequest) {
        FuncionariosModel funcionario = new FuncionariosModel();
        funcionario.setNome(funcionarioRequest.nome());
        funcionario.setCargo(funcionarioRequest.cargo());
        funcionario.setTurno(funcionarioRequest.turno());
        funcionario.setStatus("Ativo"); // Pode ser um valor padrão ou vir do DTO
        FuncionariosModel savedFuncionario = funcionariosRepository.save(funcionario);
        return funcionariosMapper.toDto(savedFuncionario);
    }

    // Buscar todos os funcionários
    public List<FuncionariosResponseDTO> findAll() {
        List<FuncionariosModel> funcionarios = funcionariosRepository.findAll();
        return funcionarios.stream()
                .map(funcionariosMapper::toDto)
                .toList();
    }

    // Buscar funcionário por ID
    public FuncionariosResponseDTO findById(UUID id) {
        FuncionariosModel funcionario = funcionariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
        return funcionariosMapper.toDto(funcionario);
    }

    // Deletar um funcionário por ID
    public void delete(UUID id) {
        funcionariosRepository.deleteById(id);
    }
}
