package com.decoder.pritam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decoder.pritam.model.Feature;
import com.decoder.pritam.repository.FeatureRepository;

@Service
public class FeatureServiceImpl implements FeatureService {
	
	@Autowired
	private FeatureRepository featureRepository;
	@Override
	public List<Feature> getAllFeatures() {
		// TODO Auto-generated method stub
		return featureRepository.findAll();

	}

	@Override
	public Feature getFeatureById(Long id) {
		// TODO Auto-generated method stub
		return featureRepository.findById(id).orElse(null);

	}

	@Override
	public Feature createFeature(Feature feature) {
		// TODO Auto-generated method stub
		return featureRepository.save(feature);

	}

	@Override
	public Feature updateFeature(Feature feature) {
		Feature existingFeature = getFeatureById(feature.getFeatureId());
        if (existingFeature != null) {
            existingFeature.setFeatureName(feature.getFeatureName());
            existingFeature.setProperty(feature.getProperty());
            return featureRepository.save(existingFeature);
        } else {
            return null;
        }

	}

	@Override
	public void deleteFeature(Long id) {
		featureRepository.deleteById(id);


	}

}
