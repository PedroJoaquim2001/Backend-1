package com.SpringTest.Teste.services;

import com.SpringTest.Teste.models.RequestsModel;
import com.SpringTest.Teste.repositories.RequestsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RequestsService {
    @Autowired
    private RequestsRepository requestsRepository;

    public List<RequestsModel> findAll(){
        return requestsRepository.findAll();
    }

    @Transactional
    public RequestsModel save(RequestsModel requestsModel){
        return requestsRepository.save(requestsModel);
    }

    //public Requests getOne(long id){return requestsRepository.getOne(id);}


    public Optional<RequestsModel> findById(UUID id) {return requestsRepository.findById(id);}

    public void delete(RequestsModel requestsModel) {requestsRepository.delete(requestsModel);}
}
