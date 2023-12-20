/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SilkRoad.Service;

import com.example.SilkRoad.Model.Post;
import com.example.SilkRoad.Model.User;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPost();

    void savePost(Post post);

    void deletePost(int id);

    Optional<Post> findPostById(int id);

    List<Post> findPostByUser(User user);
}