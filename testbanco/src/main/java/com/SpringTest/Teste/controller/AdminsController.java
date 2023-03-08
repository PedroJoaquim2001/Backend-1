package com.SpringTest.Teste.controller;

import com.SpringTest.Teste.controller.dtos.AdminsDto;
import com.SpringTest.Teste.controller.forms.AdminsForm;
import com.SpringTest.Teste.models.Admins;
import com.SpringTest.Teste.services.AdminsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminsController {

    final AdminsService adminsService;

    public AdminsController(AdminsService adminsService) {
        this.adminsService = adminsService;
    }


    @GetMapping
    public List<AdminsDto> list(){
        List<Admins> admins = adminsService.findAll();
        return AdminsDto.convert(admins);
    }

    @PostMapping
    public ResponseEntity<AdminsDto> saveAdmin(@RequestBody @Valid AdminsForm form, UriComponentsBuilder uriBuilder){
        Admins admin = form.convert();
        adminsService.save(admin);

        URI uri = uriBuilder.path("/admin/{id}").buildAndExpand(admin.getId()).toUri();
        return ResponseEntity.created(uri).body(new AdminsDto(admin));
    }
}
