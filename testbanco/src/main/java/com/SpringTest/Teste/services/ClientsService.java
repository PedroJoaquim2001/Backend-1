package com.SpringTest.Teste.services;

import com.SpringTest.Teste.models.Clients;
import com.SpringTest.Teste.repositories.ClientsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsService {
    final ClientsRepository clientsRepository;
    public ClientsService(ClientsRepository clientsRepository){
        this.clientsRepository = clientsRepository;
    }

    public List<Clients> findAll(){
        return clientsRepository.findAll();
    }

    public Clients save(Clients clients){
        return clientsRepository.save(clients);
    }

    public Clients findById(long id){
        return clientsRepository.findById(id);
    }

    public Clients getOne(long id){return clientsRepository.getOne(id);}
}
