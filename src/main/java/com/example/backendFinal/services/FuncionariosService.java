package com.example.backendFinal.services;

import com.example.backendFinal.models.FuncionariosModel;
import com.example.backendFinal.repositories.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FuncionariosService {

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    // Criar novo funcionário
    public FuncionariosModel save(FuncionariosModel funcionario) {
        return funcionariosRepository.save(funcionario);
    }

    // Listar todos os funcionários
    public List<FuncionariosModel> findAll() {
        return funcionariosRepository.findAll();
    }

    // Buscar funcionário por ID
    public Optional<FuncionariosModel> findById(UUID id) {
        return funcionariosRepository.findById(id);
    }

    // Atualizar funcionário
    public FuncionariosModel update(FuncionariosModel funcionario) {
        return funcionariosRepository.save(funcionario);
    }

    // Deletar funcionário
    public void deleteById(UUID id) {
        funcionariosRepository.deleteById(id);
    }
}
