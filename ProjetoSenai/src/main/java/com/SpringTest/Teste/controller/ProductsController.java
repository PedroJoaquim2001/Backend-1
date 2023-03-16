package com.SpringTest.Teste.controller;

import com.SpringTest.Teste.controller.dtos.ProductsDto;
import com.SpringTest.Teste.controller.forms.ProductsForm;
import com.SpringTest.Teste.models.ImageModel;
import com.SpringTest.Teste.models.ProductsModel;
import com.SpringTest.Teste.services.AdminsService;
import com.SpringTest.Teste.services.CultureService;
import com.SpringTest.Teste.services.ImageService;
import com.SpringTest.Teste.services.ProductsService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductsController {
    @Autowired
    private ProductsService productsService;
    @Autowired
    private AdminsService adminsService;
    @Autowired
    private CultureService cultureService;
    @Autowired
    private ImageService imageService;


    @GetMapping
    public ResponseEntity<List<ProductsDto>> getAll() {
        List<ProductsModel> products = productsService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(ProductsDto.convert(products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable UUID id){
        Optional<ProductsModel> productsOptional = productsService.findById(id);
        if(!productsOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ProductsDto(productsOptional.get()));
    }

    @PostMapping
    public ResponseEntity<ProductsDto> saveProduct(@RequestBody @Valid ProductsForm form, UriComponentsBuilder uriBuilder){
        ProductsModel product = form.convert(adminsService, cultureService);
        productsService.save(product);

        URI uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductsDto(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProducts(@PathVariable UUID id){
        Optional<ProductsModel> productsOptional = productsService.findById(id);
        if (!productsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product to delete not found.");
        }
        productsService.delete(productsOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable UUID id,
                                              @RequestBody @Valid ProductsForm form){
        Optional<ProductsModel> productsOptional = productsService.findById(id);
        if (!productsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product to update not found.");
        }
        var product = new ProductsModel();
        BeanUtils.copyProperties(form, product);
        product = form.convert(adminsService, cultureService);
        product.setId(productsOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(productsService.save(product));

    }

    @PutMapping("/addImage/{id}")
    public ResponseEntity<Object> addImage(@PathVariable UUID id,
                                                @RequestBody @Valid ProductsForm form){
        Optional<ProductsModel> productsOptional = productsService.findById(id);
        if (!productsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product to update not found.");
        }
        var product = new ProductsModel();
        BeanUtils.copyProperties(form, product);
        product = form.convert(adminsService, cultureService);
        product.setId(productsOptional.get().getId());
        Optional<ImageModel> imageModelOptional = imageService.findById(form.getImage_id());
        if(!imageModelOptional.isPresent()){
            productsService.save(product);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image to add not found.");
        }
        product.addImage(imageModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(productsService.save(product));

    }

}
