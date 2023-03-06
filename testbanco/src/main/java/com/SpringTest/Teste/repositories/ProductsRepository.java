package com.SpringTest.Teste.repositories;

import com.SpringTest.Teste.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products,Long> {
}
