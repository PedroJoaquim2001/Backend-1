package com.SpringTest.Teste.controller;


import com.SpringTest.Teste.controller.dto.ClientsDto;
import com.SpringTest.Teste.controller.form.ClientsForm;
import com.SpringTest.Teste.models.Clients;
import com.SpringTest.Teste.repositories.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientsController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<ClientsDto> list(){
        List<Clients> clients = clientRepository.findAll();
        return ClientsDto.convert(clients);
    }

    @PostMapping
    public ResponseEntity<ClientsDto> signUp(@RequestBody @Valid ClientsForm form, UriComponentsBuilder uriBuilder){
        Clients client = form.converter();
        clientRepository.save(client);

        URI uri = uriBuilder.path("/admin/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClientsDto(client));
    }

}
