package com.SpringTest.Teste.services;

import com.SpringTest.Teste.models.AdminsModel;
import com.SpringTest.Teste.repositories.AdminsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdminsService {
    @Autowired
    private AdminsRepository adminsRepository;

    public List<AdminsModel> findAll(){return adminsRepository.findAll();}

    @Transactional
    public AdminsModel save(AdminsModel adminsModel){
        return adminsRepository.save(adminsModel);
    }

    public Optional<AdminsModel> findById(UUID id){return adminsRepository.findById(id);}

    @Transactional
    public void delete(AdminsModel adminsModel){adminsRepository.delete(adminsModel);}

}
