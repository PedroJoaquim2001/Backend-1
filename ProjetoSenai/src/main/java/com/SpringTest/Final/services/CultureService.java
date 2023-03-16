package com.SpringTest.Final.services;

import com.SpringTest.Final.models.CultureModel;
import com.SpringTest.Final.repositories.CultureRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CultureService {
    @Autowired
    private CultureRepository cultureRepository;

    public List<CultureModel> findAll(){return cultureRepository.findAll();}

    @Transactional
    public CultureModel save(CultureModel cultureModel){
        return cultureRepository.save(cultureModel);
    }

    public Optional<CultureModel> findById(UUID id){return cultureRepository.findById(id);}

    @Transactional
    public void delete(CultureModel cultureModel){cultureRepository.delete(cultureModel);}

}
