package com.example.SocialNetwork.model;

import com.example.SocialNetwork.observer.PostObserver;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Comment> commentsList;

    @OneToMany
    private List<React>  reactsList;

    private String content;

    @Transient
    PostObserver postObserver;

    public void addObserver(){
        postObserver = new PostObserver(this);
    }

    public void addComment(Comment comment) {
        commentsList.add(comment);
        postObserver.notify(comment);

    }

    public void addReact(React react) {
        reactsList.add(react);
    }


}
