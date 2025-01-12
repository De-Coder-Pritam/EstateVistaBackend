package com.decoder.pritam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decoder.pritam.model.Image;
import com.decoder.pritam.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {
	
	
	@Autowired
	private ImageRepository imageRepository;
	@Override
	public List<Image> getAllImages() {
		return imageRepository.findAll();
	}

	@Override
	public Image getImageById(Long id) {
		return imageRepository.findById(id).orElse(null);

	}

	@Override
	public Image createImage(Image image) {
		return imageRepository.save(image);

	}

	@Override
	public Image updateImage(Image image) {
		Image existingImage = getImageById(image.getImageId());
        if (existingImage != null) {
            existingImage.setImageUrl(image.getImageUrl());
            existingImage.setProperty(image.getProperty());
            return imageRepository.save(existingImage);
        } else {
            return null;
        }

	}

	@Override
	public void deleteImage(Long id) {
		// TODO Auto-generated method stub
		imageRepository.deleteById(id);
	}

}
