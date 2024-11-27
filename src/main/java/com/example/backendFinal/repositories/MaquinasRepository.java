package com.example.backendFinal.repositories;

import com.example.backendFinal.models.MaquinasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MaquinasRepository extends JpaRepository<MaquinasModel, UUID> {
    public Optional<MaquinasModel> findById(UUID id);
}
