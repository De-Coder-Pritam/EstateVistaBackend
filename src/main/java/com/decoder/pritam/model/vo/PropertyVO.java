package com.decoder.pritam.model.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyVO {
	
	private Long propertyId;
	private String title;
	private String description;
	private Double price;
    private String address;
	
	private String city;
	
	private String state;
	
	private String postalCode;
	
	private String propertyType;
	
	private String status;
	

	
	private UserVO userVO;
	
	private List<ImageVO> imageVO;
	
	private List<FeatureVO> featureVO;
	
	private List<FavoriteVO> favoriteVO;
	
	
	
}
