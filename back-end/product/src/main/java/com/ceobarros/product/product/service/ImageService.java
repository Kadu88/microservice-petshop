package com.ceobarros.product.product.service;

import com.ceobarros.product.product.model.Image;
import com.ceobarros.product.product.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Lob;
import java.sql.Blob;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image findImageById(Integer idImage) {
        Optional<Image> existingImage = imageRepository.findById(idImage);
        return existingImage.orElse(null);
    }

    public void addImageMedium(Integer idProduct, Blob imageMedium) {
        Image image = new Image(idProduct, imageMedium);
        imageRepository.save(image);
    }
}
