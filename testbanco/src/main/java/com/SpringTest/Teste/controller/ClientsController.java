package com.SpringTest.Teste.controller;


import com.SpringTest.Teste.controller.dtos.ClientsDto;
import com.SpringTest.Teste.controller.forms.ClientsForm;
import com.SpringTest.Teste.models.Clients;
import com.SpringTest.Teste.services.ClientsService;
import jakarta.validation.Valid;
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
    public List<ClientsDto> list(){
        List<Clients> clients = clientsService.findAll();
        return ClientsDto.convert(clients);
    }

    @PostMapping
    public ResponseEntity<ClientsDto> signUp(@RequestBody @Valid ClientsForm form, UriComponentsBuilder uriBuilder){
        Clients client = form.converter();
        clientsService.save(client);

        URI uri = uriBuilder.path("/admin/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClientsDto(client));
    }

}
