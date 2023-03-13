package com.SpringTest.Teste.services;

import com.SpringTest.Teste.models.ProductsModel;
import com.SpringTest.Teste.repositories.ProductsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductsService {
    final ProductsRepository productsRepository;
    public ProductsService(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    public List<ProductsModel> findAll(){
        return productsRepository.findAll();
    }

    @Transactional
    public ProductsModel save(ProductsModel productsModel){
        return productsRepository.save(productsModel);
    }

    public Optional<ProductsModel> findById(UUID id){return productsRepository.findById(id);}

    //public ProductsModel getOne(UUID id){return productsRepository.getOne(id);}

    //public Optional<ProductsModel> findByIdOptional(Long id) {return productsRepository.findById(id);}

    public void delete(ProductsModel productsModel) {productsRepository.delete(productsModel);}
}
