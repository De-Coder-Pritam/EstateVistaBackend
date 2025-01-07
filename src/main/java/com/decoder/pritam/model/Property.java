package com.decoder.pritam.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="properties")
public class Property {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long propertyId;
	
	private String title;
	
	private Double price;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String postalCode;
	
	private String propertyType;
	
	private String status;
	
	@ManyToOne
	@JoinColumn(name="seller_id",nullable=false)
	private User user;
	
	@OneToMany(mappedBy="property",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Image> images;
	@OneToMany(mappedBy="property",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Feature> features;
	@OneToMany(mappedBy="property",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Favorite> favorites;
	
}
