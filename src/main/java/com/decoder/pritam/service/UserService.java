package com.decoder.pritam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.decoder.pritam.model.User;

@Service
public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);
    
    User getUserByEmail(String email);

}

