package com.SpringTest.Teste.repositories;

import com.SpringTest.Teste.models.CultureModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CultureRepository extends JpaRepository<CultureModel, UUID> {
    Optional<CultureModel> findById(UUID id);
}
