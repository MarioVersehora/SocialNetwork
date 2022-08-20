package com.example.SocialNetwork.repository;

import com.example.SocialNetwork.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionRepository extends JpaRepository<Reaction, Integer> {

}
