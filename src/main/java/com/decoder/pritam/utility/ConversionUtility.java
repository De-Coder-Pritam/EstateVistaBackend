package com.decoder.pritam.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.decoder.pritam.model.Favorite;
import com.decoder.pritam.model.Feature;
import com.decoder.pritam.model.Image;
import com.decoder.pritam.model.Message;
import com.decoder.pritam.model.Property;
import com.decoder.pritam.model.User;
import com.decoder.pritam.model.vo.FavoriteVO;
import com.decoder.pritam.model.vo.FeatureVO;
import com.decoder.pritam.model.vo.ImageVO;
import com.decoder.pritam.model.vo.MessageVO;
import com.decoder.pritam.model.vo.PropertyVO;
import com.decoder.pritam.model.vo.UserVO;

@Component
public class ConversionUtility {
	public List<PropertyVO> convertPropertyToVO(List<Property> repoProps){
		List<PropertyVO> voProps = new ArrayList<>();
		
		repoProps.forEach( prop->{
			PropertyVO propVO = new PropertyVO();
			propVO.setTitle(prop.getTitle());
			propVO.setDescription(prop.getDescription());
			propVO.setPrice(prop.getPrice());
			propVO.setAddress(prop.getAddress());
			propVO.setCity(prop.getCity());
			propVO.setState(prop.getState());
			propVO.setPostalCode(prop.getPostalCode());
			propVO.setPropertyId(prop.getPropertyId());
			propVO.setPropertyType(prop.getPropertyType());
			propVO.setStatus(prop.getStatus());
			propVO.setUserVO(convertToUserVO(prop.getUser()));
			propVO.setImageVO(convertToImageVO(prop.getImages()));
			propVO.setFeatureVO(convertToFeatureVO(prop.getFeatures()));
			propVO.setFavoriteVO(convertToFavoriteVO(prop.getFavorites()));
			voProps.add(propVO);

			
		});
		return voProps;
	}
	public List<ImageVO> convertToImageVO(List<Image> repoImages){
		List<ImageVO> voImages = new ArrayList<>();
		repoImages.forEach(
				img ->{
					ImageVO iv = new ImageVO();
					iv.setImageId(img.getImageId());
					iv.setImageUrl(img.getImageUrl());
					voImages.add(iv);
					
				}
				);
		return voImages;
	}
	
	public List<FavoriteVO> convertToFavoriteVO(List<Favorite> repoFavorites){
		List<FavoriteVO> voFavorites = new ArrayList<>();
		repoFavorites.forEach(
				fav ->{
					FavoriteVO fv = new FavoriteVO();
					fv.setFavoriteId(fav.getFavoriteId());
					voFavorites.add(fv);
				}
				);
		return voFavorites;
	}
	
	
	public List<FeatureVO> convertToFeatureVO(List<Feature> repoFeatures){
		List<FeatureVO> voFeatures = new ArrayList<>();
		repoFeatures.forEach(
				ftrs ->{
					FeatureVO fv = new FeatureVO();
					fv.setFeatureId(ftrs.getFeatureId());
					fv.setFeatureName(ftrs.getFeatureName());
					voFeatures.add(fv);
				}
				);
		return voFeatures;
	}
	
	
	public List<MessageVO> convertToMessageVO(List<Message> repoMessages){
		List<MessageVO> voMessages = new ArrayList<>();
		repoMessages.forEach(
				msgs ->{
					MessageVO ms = new MessageVO();
					ms.setContent(msgs.getContent());
					ms.setMessageId(msgs.getMessageId());
					ms.setTimestamp(msgs.getTimestamp());
					voMessages.add(ms);
					
				}
				);
		return voMessages;
	}
	
	
	public UserVO convertToUserVO(User usrs){
		
					UserVO us = new UserVO();
					us.setCreatedAt(usrs.getCreatedAt());
					us.setEmail(usrs.getEmail());
					us.setName(usrs.getName());
					us.setPassword(usrs.getPassword());
					us.setPhoneNumber(usrs.getPhoneNumber());
					us.setRole(usrs.getRole());
					us.setUserId(usrs.getUserId());
				
		return us;
	}
}
