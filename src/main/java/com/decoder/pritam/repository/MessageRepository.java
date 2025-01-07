package com.decoder.pritam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decoder.pritam.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
