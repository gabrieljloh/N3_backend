package com.example.backendFinal.repositories;

import com.example.backendFinal.models.OrdensModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrdensRepository extends JpaRepository<OrdensModel, UUID> {
    public Optional<OrdensModel> findById(UUID id);
}