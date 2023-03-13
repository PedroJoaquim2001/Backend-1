package com.SpringTest.Teste.controller;

import com.SpringTest.Teste.controller.dtos.RequestsDto;
import com.SpringTest.Teste.controller.forms.RequestsForm;
import com.SpringTest.Teste.models.RequestsModel;
import com.SpringTest.Teste.services.AdminsService;
import com.SpringTest.Teste.services.ClientsService;
import com.SpringTest.Teste.services.ProductsService;
import com.SpringTest.Teste.services.RequestsService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/request")
public class RequestsController {
    final AdminsService adminsService;
    final ProductsService productsService;

    final ClientsService clientsService;
    final RequestsService requestsService;

    public RequestsController(AdminsService adminsService, ProductsService productsService, ClientsService clientsService, RequestsService requestsService) {
        this.adminsService = adminsService;
        this.productsService = productsService;
        this.clientsService = clientsService;
        this.requestsService = requestsService;
    }

    @GetMapping
    public ResponseEntity<List<RequestsDto>> getAll(){
        List<RequestsModel> requestsModelList = requestsService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(RequestsDto.convert(requestsModelList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable UUID id){
        Optional<RequestsModel> requestsOptional = requestsService.findById(id);
        if(!requestsOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Request not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new RequestsDto(requestsOptional.get()));
    }

    @PostMapping
    public ResponseEntity<RequestsDto> saveRequest(@RequestBody @Valid RequestsForm form, UriComponentsBuilder uriBuilder) {
        RequestsModel requestsModel = form.convert(clientsService, productsService, adminsService);
        requestsService.save(requestsModel);

        URI uri = uriBuilder.path("/requests/{id}").buildAndExpand(requestsModel.getId()).toUri();
        return ResponseEntity.created(uri).body(new RequestsDto(requestsModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRequest(@PathVariable UUID id){
        Optional<RequestsModel> requestsOptional = requestsService.findById(id);
        if (!requestsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Request to delete not found.");
        }
        requestsService.delete(requestsOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Request deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRequest(@PathVariable UUID id,
                                                @RequestBody @Valid RequestsForm form){
        Optional<RequestsModel> requestsOptional = requestsService.findById(id);
        if (!requestsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Request to update not found.");
        }
        var request = new RequestsModel();
        BeanUtils.copyProperties(form, request);
        request = form.convert(clientsService, productsService, adminsService);
        request.setId(requestsOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(requestsService.save(request));
    }
}
