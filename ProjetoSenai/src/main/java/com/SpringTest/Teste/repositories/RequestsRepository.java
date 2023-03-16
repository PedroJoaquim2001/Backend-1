package com.SpringTest.Teste.repositories;

import com.SpringTest.Teste.models.RequestsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RequestsRepository extends JpaRepository<RequestsModel,Long> {
    Optional<RequestsModel> findById(UUID id);
}
