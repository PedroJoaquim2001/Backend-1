package com.SpringTest.Teste.controller;

import com.SpringTest.Teste.controller.dto.AdminsDto;
import com.SpringTest.Teste.controller.form.AdminsForm;
import com.SpringTest.Teste.models.Admins;
import com.SpringTest.Teste.repositories.AdminRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminsController {
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping
    public List<AdminsDto> list(){
        List<Admins> admins = adminRepository.findAll();
        return AdminsDto.convert(admins);
    }

    @PostMapping
    public ResponseEntity<AdminsDto> signUp(@RequestBody @Valid AdminsForm form, UriComponentsBuilder uriBuilder){
        Admins admin = form.convert();
        adminRepository.save(admin);

        URI uri = uriBuilder.path("/admin/{id}").buildAndExpand(admin.getId()).toUri();
        return ResponseEntity.created(uri).body(new AdminsDto(admin));
    }
}
