package com.SpringTest.Final.controller;

import com.SpringTest.Final.controller.dtos.AdminsDto;
import com.SpringTest.Final.controller.forms.AdminsForm;
import com.SpringTest.Final.models.AdminsModel;
import com.SpringTest.Final.services.AdminsService;
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
@RequestMapping("/admin")
public class AdminsController {
    @Autowired
    private AdminsService adminsService;


    @GetMapping
    public ResponseEntity<List<AdminsDto>> getAll(){
        List<AdminsModel> admins = adminsService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(AdminsDto.convert(admins));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable UUID id){
        Optional<AdminsModel> adminsOptional = adminsService.findById(id);
        if(!adminsOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new AdminsDto(adminsOptional.get()));
    }

    @PostMapping
    public ResponseEntity<AdminsDto> saveAdmin(@RequestBody @Valid AdminsForm form, UriComponentsBuilder uriBuilder){
        AdminsModel admin = form.convert();
        adminsService.save(admin);

        URI uri = uriBuilder.path("/admin/{id}").buildAndExpand(admin.getId()).toUri();
        return ResponseEntity.created(uri).body(new AdminsDto(admin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAdmin(@PathVariable UUID id){
        Optional<AdminsModel> adminsOptional = adminsService.findById(id);
        if (!adminsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin to delete not found.");
        }
        adminsService.delete(adminsOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Admin deleted successfully.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAdmin(@PathVariable UUID id,
                                                    @RequestBody @Valid AdminsForm form){
        Optional<AdminsModel> adminsOptional = adminsService.findById(id);
        if (!adminsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin to update not found.");
        }
        var admin = new AdminsModel();
        BeanUtils.copyProperties(form, admin);
        admin = form.convert();
        admin.setId(adminsOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(adminsService.save(admin));
    }
}
