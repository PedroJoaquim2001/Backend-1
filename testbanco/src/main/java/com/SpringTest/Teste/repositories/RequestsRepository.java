package com.SpringTest.Teste.repositories;

import com.SpringTest.Teste.models.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestsRepository extends JpaRepository<Requests,Long> {
}
