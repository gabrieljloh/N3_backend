package com.example.backendFinal.repositories;

import com.example.backendFinal.models.FuncionariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FuncionariosRepository  extends JpaRepository<FuncionariosModel, UUID> {
}
