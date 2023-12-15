package com.example.service;

import com.example.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPost();

    void savePost(Post post);

    void deletePost(Long id);

    Optional<Post> findPostById(Long id);
}