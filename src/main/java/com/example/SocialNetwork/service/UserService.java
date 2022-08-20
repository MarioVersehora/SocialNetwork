package com.example.SocialNetwork.service;

import com.example.SocialNetwork.model.User;
import com.example.SocialNetwork.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsersByName(String name) {
        return userRepository.findAllByName(name);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }







}
