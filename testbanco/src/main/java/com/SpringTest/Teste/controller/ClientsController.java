package com.SpringTest.Teste.controller;


import com.SpringTest.Teste.controller.dtos.ClientsDto;
import com.SpringTest.Teste.controller.forms.ClientsForm;
import com.SpringTest.Teste.models.Clients;
import com.SpringTest.Teste.services.ClientsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientsController {
    final ClientsService clientsService;

    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @GetMapping
    public ResponseEntity<List<ClientsDto>> getAll(){
        List<Clients> clients = clientsService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(ClientsDto.convert(clients));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientsDto> getOne(@PathVariable Long id){
        Clients clients = clientsService.getOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ClientsDto(clients));
    }

    @PostMapping
    public ResponseEntity<ClientsDto> saveClient(@RequestBody @Valid ClientsForm form, UriComponentsBuilder uriBuilder){
        Clients client = form.converter();
        clientsService.save(client);

        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClientsDto(client));
    }

}
