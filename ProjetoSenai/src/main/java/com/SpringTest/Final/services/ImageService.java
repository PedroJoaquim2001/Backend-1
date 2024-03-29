package com.SpringTest.Final.services;

import com.SpringTest.Final.controller.dtos.ImageDto;
import com.SpringTest.Final.models.ImageModel;
import com.SpringTest.Final.repositories.ImageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public String uploadImage(MultipartFile file) throws IOException {

        ImageModel imageModel = this.imageRepository.save(com.SpringTest.Final.models.ImageModel.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageDto.compressImage(file.getBytes())).build());
        if (imageModel != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }


    public byte[] downloadImage(ImageModel imageModel){
        byte[] images= ImageDto.decompressImage(imageModel.getImageData());
        return images;
    }

    public Optional<ImageModel> findById(UUID id){return imageRepository.findById(id);}

    @Transactional
    public void delete(ImageModel imageModel) {imageRepository.delete(imageModel);}

    public List<ImageModel> findAll(){return imageRepository.findAll();}

}
