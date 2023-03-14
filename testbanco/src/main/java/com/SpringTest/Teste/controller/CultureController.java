package com.SpringTest.Teste.controller;

import com.SpringTest.Teste.controller.dtos.CultureDto;
import com.SpringTest.Teste.controller.forms.CultureForm;
import com.SpringTest.Teste.models.CultureModel;
import com.SpringTest.Teste.services.CultureService;
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
@RequestMapping("/culture")
public class CultureController {
    @Autowired
    private CultureService cultureService;


    @GetMapping
    public ResponseEntity<List<CultureDto>> getAll(){
        List<CultureModel> cultureModels = cultureService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(CultureDto.convert(cultureModels));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable UUID id){
        Optional<CultureModel> cultureModelOptional = cultureService.findById(id);
        if(!cultureModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Culture not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new CultureDto(cultureModelOptional.get()));
    }

    @PostMapping
    public ResponseEntity<CultureDto> saveCulture(@RequestBody @Valid CultureForm form, UriComponentsBuilder uriBuilder){
        CultureModel cultureModel = form.convert();
        cultureService.save(cultureModel);

        URI uri = uriBuilder.path("/culture/{id}").buildAndExpand(cultureModel.getId()).toUri();
        return ResponseEntity.created(uri).body(new CultureDto(cultureModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCulture(@PathVariable UUID id){
        Optional<CultureModel> cultureModelOptional = cultureService.findById(id);
        if (!cultureModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Culture to delete not found.");
        }
        cultureService.delete(cultureModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Culture deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCulture(@PathVariable UUID id,
                                              @RequestBody @Valid CultureForm form){
        Optional<CultureModel> cultureModelOptional = cultureService.findById(id);
        if (!cultureModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Culture to update not found.");
        }
        var culture = new CultureModel();
        BeanUtils.copyProperties(form, culture);
        culture = form.convert();
        culture.setId(cultureModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(cultureService.save(culture));
    }
}
