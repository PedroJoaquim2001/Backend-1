package com.SpringTest.Teste.controller;

import com.SpringTest.Teste.controller.dto.ProductsDto;
import com.SpringTest.Teste.controller.form.ProductsForm;
import com.SpringTest.Teste.models.Products;
import com.SpringTest.Teste.repositories.AdminRepository;
import com.SpringTest.Teste.repositories.ProductsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping
    public List<ProductsDto> list() {
        List<Products> products = productsRepository.findAll();
        return ProductsDto.convert(products);
    }

    @PostMapping
    public ResponseEntity<ProductsDto> signUp(@RequestBody @Valid ProductsForm form, UriComponentsBuilder uriBuilder){
        Products product = form.convert(adminRepository);
        productsRepository.save(product);

        URI uri = uriBuilder.path("/Products/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductsDto(product));
    }
}
