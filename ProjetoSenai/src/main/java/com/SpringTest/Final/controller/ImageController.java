package com.SpringTest.Final.controller;

import com.SpringTest.Final.models.ImageModel;
import com.SpringTest.Final.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = imageService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> downloadImage(@PathVariable UUID id){
        Optional<ImageModel> imageModelOptional = imageService.findById(id);
        if(!imageModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found");
        }
        byte[] imageData= imageService.downloadImage(imageModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteImage(@PathVariable UUID id){
        Optional<ImageModel> imageModelOptional = imageService.findById(id);
        if (!imageModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image to delete not found.");
        }
        imageService.delete(imageModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Image deleted successfully.");
    }

}
