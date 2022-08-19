package com.example.SocialNetwork.repository;

import com.example.SocialNetwork.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
