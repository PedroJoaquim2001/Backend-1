package com.SpringTest.Teste.repositories;

import com.SpringTest.Teste.models.ClientsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientsRepository extends JpaRepository<ClientsModel, Long> {
    Optional<ClientsModel> findById(UUID id);
}
