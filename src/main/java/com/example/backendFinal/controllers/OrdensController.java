package com.example.backendFinal.controllers;

import com.example.backendFinal.dtos.OrdensRequestDTO;
import com.example.backendFinal.dtos.OrdensResponseDTO;
import com.example.backendFinal.dtos.ErroDTO;
import com.example.backendFinal.services.OrdensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/ordens")
@Validated
public class OrdensController {

    @Autowired
    private OrdensService ordensService;

    // Criar uma nova ordem de serviço
    @PostMapping
    public ResponseEntity<OrdensResponseDTO> create(@Valid @RequestBody OrdensRequestDTO ordensRequest) {
        OrdensResponseDTO ordensResponse = ordensService.save(ordensRequest);
        return new ResponseEntity<>(ordensResponse, HttpStatus.CREATED);
    }

    // Buscar todas as ordens de serviço
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(ordensService.findAll());
    }

    // Buscar ordem de serviço por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) {
        try {
            OrdensResponseDTO ordensResponse = ordensService.findById(id);
            return ResponseEntity.ok(ordensResponse);
        } catch (RuntimeException e) {
            ErroDTO erroDTO = new ErroDTO(HttpStatus.NOT_FOUND, "Ordem de serviço não encontrada");
            return new ResponseEntity<>(erroDTO, HttpStatus.NOT_FOUND);
        }
    }

    // Deletar ordem de serviço por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        try {
            ordensService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            ErroDTO erroDTO = new ErroDTO(HttpStatus.NOT_FOUND, "Ordem de serviço não encontrada");
            return new ResponseEntity<>(erroDTO, HttpStatus.NOT_FOUND);
        }
    }
}
