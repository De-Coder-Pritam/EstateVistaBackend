package com.decoder.pritam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.decoder.pritam.model.Property;


@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

}
