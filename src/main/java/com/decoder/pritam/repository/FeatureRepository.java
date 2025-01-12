package com.decoder.pritam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.decoder.pritam.model.Feature;


@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {

}
