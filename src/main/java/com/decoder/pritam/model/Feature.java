package com.decoder.pritam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="features")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Feature {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long featureId;
	
	private String featureName;
	
	@ManyToOne
	@JoinColumn(name="property_id",nullable=false)
	private Property property;
}
