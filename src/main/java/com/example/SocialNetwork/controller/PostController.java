package com.example.SocialNetwork.controller;

import com.example.SocialNetwork.model.Post;
import com.example.SocialNetwork.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public Post savePost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @GetMapping("last-ten")
    public List<Post> getLastTenPosts() {
        return postService.getLastTenPosts();
    }

    @GetMapping("ten-reacts")
    public List<Post> getPostsWithMoreThanTenLikes() {
        return postService.getPostsWithMoreThanTenLikes();
    }

    @PostMapping("add-react/{postId}/{react}")
    public void addReactToPost(@PathVariable Integer postId, @PathVariable String react)  {
        postService.addReactionToPost(postId, react);
    }

    @PostMapping("add-comment/{userId}/{postId}/{comment}")
    public void addCommentToPost(@PathVariable Integer userId, @PathVariable Integer postId, @PathVariable String comment) {
        postService.addCommentToPost(userId, postId, comment);
    }

}
