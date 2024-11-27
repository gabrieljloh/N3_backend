package com.example.backendFinal.controllers;

import com.example.backendFinal.dtos.FuncionariosRequestDTO;
import com.example.backendFinal.dtos.FuncionariosResponseDTO;
import com.example.backendFinal.dtos.ErroDTO;
import com.example.backendFinal.services.FuncionariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/funcionarios")
@Validated
public class FuncionariosController {

    @Autowired
    private FuncionariosService funcionariosService;

    // Criar um novo funcionário
    @PostMapping
    public ResponseEntity<FuncionariosResponseDTO> create(@Valid @RequestBody FuncionariosRequestDTO funcionarioRequest) {
        FuncionariosResponseDTO funcionarioResponse = funcionariosService.save(funcionarioRequest);
        return new ResponseEntity<>(funcionarioResponse, HttpStatus.CREATED);
    }

    // Buscar todos os funcionários
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(funcionariosService.findAll());
    }

    // Buscar funcionário por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) {
        try {
            FuncionariosResponseDTO funcionarioResponse = funcionariosService.findById(id);
            return ResponseEntity.ok(funcionarioResponse);
        } catch (RuntimeException e) {
            ErroDTO erroDTO = new ErroDTO(HttpStatus.NOT_FOUND, "Funcionário não encontrado");
            return new ResponseEntity<>(erroDTO, HttpStatus.NOT_FOUND);
        }
    }

    // Deletar funcionário por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        try {
            funcionariosService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            ErroDTO erroDTO = new ErroDTO(HttpStatus.NOT_FOUND, "Funcionário não encontrado");
            return new ResponseEntity<>(erroDTO, HttpStatus.NOT_FOUND);
        }
    }
}
