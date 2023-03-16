package com.SpringTest.Final.services;

import com.SpringTest.Final.models.ClientsModel;
import com.SpringTest.Final.repositories.ClientsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientsService {
    @Autowired
    private ClientsRepository clientsRepository;

    public List<ClientsModel> findAll(){
        return clientsRepository.findAll();
    }

    @Transactional
    public ClientsModel save(ClientsModel clientsModel){
        return clientsRepository.save(clientsModel);
    }

    public Optional<ClientsModel> findById(UUID id){
        return clientsRepository.findById(id);
    }

    //public ClientsModel getOne(long id){return clientsRepository.getOne(id);}

    //public Optional<ClientsModel> findByIdOptional(Long id) {return clientsRepository.findById(id);}

    public void delete(ClientsModel clientsModel) {clientsRepository.delete(clientsModel);}
}
