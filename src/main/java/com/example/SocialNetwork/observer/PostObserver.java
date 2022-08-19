package com.example.SocialNetwork.observer;

import com.example.SocialNetwork.model.Comment;
import com.example.SocialNetwork.model.Post;


public class PostObserver {

    private Post observedPost;

    public PostObserver(Post p) {
        this.observedPost = p;
    }

    public void notify(Comment comment) {
        System.out.println(observedPost.getUser().getName() + ": You have a new comment." + comment.getContent());
    }

}
