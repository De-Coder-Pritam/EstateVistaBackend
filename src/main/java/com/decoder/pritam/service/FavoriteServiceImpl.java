package com.decoder.pritam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decoder.pritam.model.Favorite;
import com.decoder.pritam.repository.FavoriteRepository;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	@Override
	public List<Favorite> getAllFavorites() {
		// TODO Auto-generated method stub
		return favoriteRepository.findAll();
	}

	@Override
	public Favorite getFavoriteById(Long id) {
		// TODO Auto-generated method stub
		return favoriteRepository.findById(id).orElse(null);

	}

	@Override
	public Favorite createFavorite(Favorite favorite) {
		// TODO Auto-generated method stub
		return favoriteRepository.save(favorite);

	}

	@Override
	public Favorite updateFavorite(Favorite favorite) {
		Favorite existingFavorite = getFavoriteById(favorite.getFavoriteId());
        if (existingFavorite != null) {
            existingFavorite.setUser(favorite.getUser());
            existingFavorite.setProperty(favorite.getProperty());
            return favoriteRepository.save(existingFavorite);
        } else {
            return null;
        }

	}

	@Override
	public void deleteFavorite(Long id) {
		favoriteRepository.deleteById(id);

	}

}
