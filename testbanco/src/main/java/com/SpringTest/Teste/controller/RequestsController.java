package com.SpringTest.Teste.controller;

import com.SpringTest.Teste.controller.dtos.RequestsDto;
import com.SpringTest.Teste.controller.forms.RequestsForm;
import com.SpringTest.Teste.models.Requests;
import com.SpringTest.Teste.services.AdminsService;
import com.SpringTest.Teste.services.ClientsService;
import com.SpringTest.Teste.services.ProductsService;
import com.SpringTest.Teste.services.RequestsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
        List<Requests> requestsList = requestsService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(RequestsDto.convert(requestsList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestsDto> getOne(@PathVariable Long id){
        Requests requests = requestsService.getOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(new RequestsDto(requests));
    }

    @PostMapping
    public ResponseEntity<RequestsDto> saveRequest(@RequestBody @Valid RequestsForm form, UriComponentsBuilder uriBuilder) {
        Requests requests = form.convert(clientsService, productsService, adminsService);
        requestsService.save(requests);

        URI uri = uriBuilder.path("/requests/{id}").buildAndExpand(requests.getId()).toUri();
        return ResponseEntity.created(uri).body(new RequestsDto(requests));
    }
}
