package com.example.SocialNetwork.repository;

import com.example.SocialNetwork.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByName(String name);

}
