package com.SpringTest.Teste.repositories;

import com.SpringTest.Teste.models.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admins, Long> {
    List<Admins> findByName(String nameSearch);
    Admins findById(long id);
}
