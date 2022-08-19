package com.example.SocialNetwork.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class React {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;


}
