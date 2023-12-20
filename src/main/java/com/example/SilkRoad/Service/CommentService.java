/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SilkRoad.Service;

import com.example.SilkRoad.Model.Comment;

import java.util.List;

public interface CommentService {
    void saveComment(Comment comment);
    void deleteComment(int id);
    List<Comment> findCommentsByPostId(int postId);
    Comment findCommentById(int id);
}
