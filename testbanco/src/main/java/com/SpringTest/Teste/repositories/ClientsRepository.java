package com.SpringTest.Teste.repositories;

import com.SpringTest.Teste.models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
    Clients findById(long id);
}
