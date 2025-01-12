package com.decoder.pritam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.decoder.pritam.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
