package com.example.SocialNetwork.service;

import com.example.SocialNetwork.factory.ReactFactory;
import com.example.SocialNetwork.model.Comment;
import com.example.SocialNetwork.model.Post;
import com.example.SocialNetwork.repository.PostRepository;
import com.example.SocialNetwork.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getLastTenPosts() {
//        return postRepository.getTop10Posts();
        return postRepository.findAll().stream()
                .skip(postRepository.count() - 10)
                .collect(Collectors.toList());
    }

    public List<Post> getPostsWithMoreThanTenLikes() { // aici am facut putin diferit fata de cerinta
        return postRepository.findAll().stream()
                .filter(e -> e.getReactsList().size() >= 10)
                .collect(Collectors.toList());
    }

    public void addReactionToPost(Integer postId, String reaction) {
       Post post = postRepository.findById(postId).get();
       post.addReact(ReactFactory.createReact(reaction));
       postRepository.save(post);
    }

    public void addCommentToPost(Integer postId, Integer userId, String comment) {
        Date currentDate = Date.valueOf(String.valueOf(LocalDateTime.now()));
        Comment myComment = new Comment(
                null,
                currentDate,
                userRepository.findById(userId).get(),
                comment
        );

        Post post = postRepository.findById(postId).get();
        post.addComment(myComment);
        postRepository.save(post);

    }


}
