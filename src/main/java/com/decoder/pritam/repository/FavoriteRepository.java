package com.decoder.pritam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.decoder.pritam.model.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

}
