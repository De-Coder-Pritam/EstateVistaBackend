package com.decoder.pritam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.decoder.pritam.model.Favorite;

@Service
public interface FavoriteService {
	
	
	List<Favorite> getAllFavorites();

    Favorite getFavoriteById(Long id);

    Favorite createFavorite(Favorite favorite);

    Favorite updateFavorite(Favorite favorite);

    void deleteFavorite(Long id);

}
