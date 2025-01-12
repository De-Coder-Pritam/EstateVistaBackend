package com.decoder.pritam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decoder.pritam.model.Property;
import com.decoder.pritam.repository.PropertyRepository;

@Service
public class PropertyServiceImpl implements PropertyService{
	
	@Autowired
	private PropertyRepository propertyRepository;
	@Override
	public List<Property> getAllProperties() {
		// TODO Auto-generated method stub
		return propertyRepository.findAll();
	}

	@Override
	public Property getPropertyById(Long Id) {
		// TODO Auto-generated method stub
		return propertyRepository.findById(Id).orElse(null);

	}

	@Override
	public Property createProperty(Property property) {
		// TODO Auto-generated method stub
		return propertyRepository.save(property);

	}

	@Override
	public Property updateProperty(Property property) {
		Property existingProperty = getPropertyById(property.getPropertyId());
        if (existingProperty != null) {
            existingProperty.setTitle(property.getTitle());
            existingProperty.setDescription(property.getDescription());
            existingProperty.setPrice(property.getPrice());
            existingProperty.setAddress(property.getAddress());
            existingProperty.setCity(property.getCity());
            existingProperty.setState(property.getState());
            existingProperty.setPostalCode(property.getPostalCode());
            existingProperty.setPropertyType(property.getPropertyType());
            existingProperty.setStatus(property.getStatus());
            return propertyRepository.save(existingProperty);
        }else {
        	return null;
        }
	}

	@Override
	public void deleteProperty(Long id) {
		// TODO Auto-generated method stub
		propertyRepository.deleteById(id);

	}

}
