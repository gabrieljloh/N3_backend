package com.example.backendFinal.controllers;

import com.example.backendFinal.dtos.MaquinasRequestDTO;
import com.example.backendFinal.dtos.MaquinasResponseDTO;
import com.example.backendFinal.dtos.ErroDTO;
import com.example.backendFinal.services.MaquinasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/maquinas")
@Validated
public class MaquinasController {

    @Autowired
    private MaquinasService maquinasService;

    // Criar uma nova máquina
    @PostMapping
    public ResponseEntity<MaquinasResponseDTO> create(@Valid @RequestBody MaquinasRequestDTO maquinaRequest) {
        MaquinasResponseDTO maquinaResponse = maquinasService.save(maquinaRequest);
        return new ResponseEntity<>(maquinaResponse, HttpStatus.CREATED);
    }

    // Buscar todas as máquinas
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(maquinasService.findAll());
    }

    // Buscar máquina por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) {
        try {
            MaquinasResponseDTO maquinaResponse = maquinasService.findById(id);
            return ResponseEntity.ok(maquinaResponse);
        } catch (RuntimeException e) {
            ErroDTO erroDTO = new ErroDTO(HttpStatus.NOT_FOUND, "Máquina não encontrada");
            return new ResponseEntity<>(erroDTO, HttpStatus.NOT_FOUND);
        }
    }

    // Deletar máquina por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        try {
            maquinasService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            ErroDTO erroDTO = new ErroDTO(HttpStatus.NOT_FOUND, "Máquina não encontrada");
            return new ResponseEntity<>(erroDTO, HttpStatus.NOT_FOUND);
        }
    }
}
