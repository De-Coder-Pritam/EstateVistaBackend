package com.decoder.pritam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decoder.pritam.model.Message;
import com.decoder.pritam.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	@Override
	public List<Message> getAllMessages() {
		return messageRepository.findAll();

	}

	@Override
	public Message getMessageById(Long id) {
		return messageRepository.findById(id).orElse(null);

	}

	@Override
	public Message createMessage(Message message) {
		return messageRepository.save(message);// TODO Auto-generated method stub
		
	}

	@Override
	public Message updateMessage(Message message) {
		Message existingMessage = getMessageById(message.getMessageId());
        if (existingMessage != null) {
            existingMessage.setContent(message.getContent());
            existingMessage.setTimestamp(message.getTimestamp());
            existingMessage.setSender(message.getSender());
            existingMessage.setReceiver(message.getReceiver());
            existingMessage.setProperty(message.getProperty());
            return messageRepository.save(existingMessage);
        } else {
            return null;
        }

	}

	@Override
	public void deleteMessage(Long id) {
		messageRepository.deleteById(id);

	}

}
