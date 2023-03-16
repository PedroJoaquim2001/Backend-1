package com.SpringTest.Teste.repositories;

import com.SpringTest.Teste.models.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductsRepository extends JpaRepository<ProductsModel,Long> {
    Optional<ProductsModel> findById(UUID id);

}
