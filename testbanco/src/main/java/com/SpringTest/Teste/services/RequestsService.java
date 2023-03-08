package com.SpringTest.Teste.services;

import com.SpringTest.Teste.models.Requests;
import com.SpringTest.Teste.repositories.RequestsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestsService {
    final RequestsRepository requestsRepository;

    public RequestsService(RequestsRepository requestsRepository) {this.requestsRepository = requestsRepository;}

    public List<Requests> findAll(){
        return requestsRepository.findAll();
    }

    @Transactional
    public Requests save(Requests requests){
        return requestsRepository.save(requests);
    }

    public Requests getOne(long id){return requestsRepository.getOne(id);}


}
