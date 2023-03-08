package com.SpringTest.Teste.controller;

import com.SpringTest.Teste.controller.dtos.ProductsDto;
import com.SpringTest.Teste.controller.forms.ProductsForm;
import com.SpringTest.Teste.models.Products;
import com.SpringTest.Teste.services.AdminsService;
import com.SpringTest.Teste.services.ProductsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductsController {
    final ProductsService productsService;
    final AdminsService adminsService;
    public ProductsController(AdminsService adminsService, ProductsService productsService) {
        this.adminsService = adminsService;
        this.productsService = productsService;
    }

    @GetMapping
    public List<ProductsDto> list() {
        List<Products> products = productsService.findAll();
        return ProductsDto.convert(products);
    }

    @PostMapping
    public ResponseEntity<ProductsDto> signUp(@RequestBody @Valid ProductsForm form, UriComponentsBuilder uriBuilder){
        Products product = form.convert(adminsService);
        productsService.save(product);

        URI uri = uriBuilder.path("/Products/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductsDto(product));
    }
}
