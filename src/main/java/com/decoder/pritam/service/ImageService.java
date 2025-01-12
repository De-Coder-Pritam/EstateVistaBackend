package com.decoder.pritam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.decoder.pritam.model.Image;

@Service
public interface ImageService {
	List<Image> getAllImages();

    Image getImageById(Long id);

    Image createImage(Image image);

    Image updateImage(Image image);

    void deleteImage(Long id);

}
