package com.decoder.pritam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decoder.pritam.model.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

}
