package com.decoder.pritam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.decoder.pritam.model.Message;

@Service
public interface MessageService {
	List<Message> getAllMessages();

    Message getMessageById(Long id);

    Message createMessage(Message message);

    Message updateMessage(Message message);

    void deleteMessage(Long id);
}
