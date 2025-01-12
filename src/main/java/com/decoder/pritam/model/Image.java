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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="images")
@Builder
public class Image {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long imageId;
	
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn(name="property_id",nullable=false)
	private Property property;
	
}
