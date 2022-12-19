package com.example.post;

import com.example.user.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public PostModel findPostByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    public Integer addPost(PostModel post) {
        PostModel newPost = postRepository.save(post);
        return newPost.getUid();
    }
}
