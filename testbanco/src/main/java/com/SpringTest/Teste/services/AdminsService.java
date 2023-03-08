package com.SpringTest.Teste.services;

import com.SpringTest.Teste.models.Admins;
import com.SpringTest.Teste.repositories.AdminsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminsService {
    final AdminsRepository adminsRepository;

    public AdminsService(AdminsRepository adminsRepository) {
        this.adminsRepository = adminsRepository;
    }

    public List<Admins> findAll(){
        return adminsRepository.findAll();
    }

    @Transactional
    public Admins save(Admins admins){
        return adminsRepository.save(admins);
    }

    public Admins findById(long id){
        return adminsRepository.findById(id);
    }

}
