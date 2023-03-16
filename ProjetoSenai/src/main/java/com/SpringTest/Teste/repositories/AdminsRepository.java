package com.SpringTest.Teste.repositories;

import com.SpringTest.Teste.models.AdminsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AdminsRepository extends JpaRepository<AdminsModel, UUID> {
    List<AdminsModel> findByName(String nameSearch);
    Optional<AdminsModel> findById(UUID id);
}
