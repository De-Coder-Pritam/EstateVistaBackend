package com.decoder.pritam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.decoder.pritam.model.Feature;

@Service
public interface FeatureService {
	List<Feature> getAllFeatures();

    Feature getFeatureById(Long id);

    Feature createFeature(Feature feature);

    Feature updateFeature(Feature feature);

    void deleteFeature(Long id);

}
