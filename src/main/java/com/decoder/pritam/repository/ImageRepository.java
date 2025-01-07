package com.decoder.pritam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decoder.pritam.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
