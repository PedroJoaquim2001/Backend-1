package com.SpringTest.Teste.services;

import com.SpringTest.Teste.models.AdminsModel;
import com.SpringTest.Teste.models.CultureModel;
import com.SpringTest.Teste.repositories.CultureRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CultureService {
    final CultureRepository cultureRepository;

    public CultureService(CultureRepository cultureRepository) {this.cultureRepository = cultureRepository;}

    public List<CultureModel> findAll(){return cultureRepository.findAll();}

    @Transactional
    public CultureModel save(CultureModel cultureModel){
        return cultureRepository.save(cultureModel);
    }

    public Optional<CultureModel> findById(UUID id){return cultureRepository.findById(id);}

    @Transactional
    public void delete(CultureModel cultureModel){cultureRepository.delete(cultureModel);}

}
