package com.example.backendFinal.controllers;

import com.example.backendFinal.dtos.FuncionariosRequestDTO;
import com.example.backendFinal.dtos.FuncionariosResponseDTO;
import com.example.backendFinal.mappers.FuncionariosMapper;
import com.example.backendFinal.models.FuncionariosModel;
import com.example.backendFinal.services.FuncionariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionarios")
@Validated
public class FuncionariosController {

    @Autowired
    private FuncionariosService funcionariosService;

    @Autowired
    private FuncionariosMapper funcionariosMapper;

    // Criar novo funcionário
    @PostMapping
    public ResponseEntity<FuncionariosResponseDTO> create(@Valid @RequestBody FuncionariosRequestDTO funcionarioRequest) {
        FuncionariosModel funcionario = new FuncionariosModel();
        funcionario.setNome(funcionarioRequest.nome());
        funcionario.setCargo(funcionarioRequest.cargo());
        funcionario.setTurno(funcionarioRequest.turno());
        funcionario.setStatus("Ativo"); // Caso queira um valor padrão para status

        FuncionariosModel savedFuncionario = funcionariosService.save(funcionario);
        return ResponseEntity.ok(funcionariosMapper.toDto(savedFuncionario));
    }

    // Listar todos os funcionários
    @GetMapping
    public ResponseEntity<List<FuncionariosResponseDTO>> getAll() {
        List<FuncionariosResponseDTO> funcionarios = funcionariosService.findAll()
                .stream()
                .map(funcionariosMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(funcionarios);
    }

    // Buscar funcionário por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) {
        Optional<FuncionariosModel> funcionario = funcionariosService.findById(id);
        return funcionario.map(value -> ResponseEntity.ok(funcionariosMapper.toDto(value)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar funcionário por ID
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @Valid @RequestBody FuncionariosRequestDTO updatedFuncionario) {
        Optional<FuncionariosModel> existingFuncionario = funcionariosService.findById(id);
        if (existingFuncionario.isPresent()) {
            FuncionariosModel funcionario = existingFuncionario.get();
            funcionario.setNome(updatedFuncionario.nome());
            funcionario.setCargo(updatedFuncionario.cargo());
            funcionario.setTurno(updatedFuncionario.turno());
            funcionario.setStatus("Ativo"); // ou algum valor atualizado

            return ResponseEntity.ok(funcionariosMapper.toDto(funcionariosService.save(funcionario)));
        }
        return ResponseEntity.notFound().build();
    }

    // Deletar funcionário por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (funcionariosService.findById(id).isPresent()) {
            funcionariosService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
