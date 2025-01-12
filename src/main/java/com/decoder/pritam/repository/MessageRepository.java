package com.decoder.pritam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.decoder.pritam.model.Message;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
