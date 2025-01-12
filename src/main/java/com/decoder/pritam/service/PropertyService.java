package com.decoder.pritam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.decoder.pritam.model.Property;

@Service
public interface PropertyService {
	
	List<Property> getAllProperties();
	Property getPropertyById(Long Id);
	
	Property createProperty(Property property);

    Property updateProperty(Property property);

    void deleteProperty(Long id);

}
