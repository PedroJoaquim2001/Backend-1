package com.SpringTest.Final.controller;


import com.SpringTest.Final.controller.dtos.ClientsDto;
import com.SpringTest.Final.controller.forms.ClientsForm;
import com.SpringTest.Final.models.ClientsModel;
import com.SpringTest.Final.services.ClientsService;
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
@RequestMapping("/client")
public class ClientsController {
    @Autowired
    private ClientsService clientsService;

    @GetMapping
    public ResponseEntity<List<ClientsDto>> getAll(){
        List<ClientsModel> clients = clientsService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(ClientsDto.convert(clients));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable UUID id){
        Optional<ClientsModel> clientsOptional = clientsService.findById(id);
        if(!clientsOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ClientsDto(clientsOptional.get()));
    }

    @PostMapping
    public ResponseEntity<ClientsDto> saveClient(@RequestBody @Valid ClientsForm form, UriComponentsBuilder uriBuilder){
        ClientsModel client = form.convert();
        clientsService.save(client);

        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClientsDto(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable UUID id){
        Optional<ClientsModel> clientsOptional = clientsService.findById(id);
        if (!clientsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client to delete not found.");
        }
        clientsService.delete(clientsOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Client deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClients(@PathVariable UUID id,
                                              @RequestBody @Valid ClientsForm form){
        Optional<ClientsModel> clientsOptional = clientsService.findById(id);
        if (!clientsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client to update not found.");
        }
        var client = new ClientsModel();
        BeanUtils.copyProperties(form, client);
        client = form.convert();
        client.setId(clientsOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(clientsService.save(client));
    }

}
