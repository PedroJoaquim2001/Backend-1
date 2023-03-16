package com.SpringTest.Final.services;

import com.SpringTest.Final.models.ProductsModel;
import com.SpringTest.Final.repositories.ProductsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    public List<ProductsModel> findAll(){
        return productsRepository.findAll();
    }

    @Transactional
    public ProductsModel save(ProductsModel productsModel){
        return productsRepository.save(productsModel);
    }

    public Optional<ProductsModel> findById(UUID id){return productsRepository.findById(id);}

    public void delete(ProductsModel productsModel) {productsRepository.delete(productsModel);}
}
