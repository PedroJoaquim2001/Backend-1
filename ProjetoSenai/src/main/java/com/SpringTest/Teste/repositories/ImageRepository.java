package com.SpringTest.Teste.repositories;

import com.SpringTest.Teste.models.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ImageRepository extends JpaRepository<ImageModel, UUID> {
    Optional<ImageModel> findById(UUID id);
}
