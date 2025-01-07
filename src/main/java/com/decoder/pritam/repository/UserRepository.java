package com.decoder.pritam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decoder.pritam.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
