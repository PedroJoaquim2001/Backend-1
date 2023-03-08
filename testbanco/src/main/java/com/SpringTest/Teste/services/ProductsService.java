package com.SpringTest.Teste.services;

import com.SpringTest.Teste.models.Products;
import com.SpringTest.Teste.repositories.ProductsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    final ProductsRepository productsRepository;
    public ProductsService(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    public List<Products> findAll(){
        return productsRepository.findAll();
    }

    @Transactional
    public Products save(Products products){
        return productsRepository.save(products);
    }

    public Products findById(long id){return productsRepository.findById(id);}

    public Products getOne(long id){return productsRepository.getOne(id);}
}
