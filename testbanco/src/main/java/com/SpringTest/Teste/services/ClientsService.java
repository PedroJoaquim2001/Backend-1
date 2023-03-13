package com.SpringTest.Teste.services;

import com.SpringTest.Teste.models.ClientsModel;
import com.SpringTest.Teste.repositories.ClientsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientsService {
    final ClientsRepository clientsRepository;
    public ClientsService(ClientsRepository clientsRepository){
        this.clientsRepository = clientsRepository;
    }

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
